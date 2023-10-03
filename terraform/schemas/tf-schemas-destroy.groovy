pipeline {
    agent any 
    

    tools {
        terraform 'terraform'
    }

    stages {
        stage('Get Branch') {
            steps {
                script {
                    branchName = scm.branches[0].name.replaceAll("origin/", "")
                }
            }
        }
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Terraform init') {
            steps {
                dir('terraform/infra') {
                    sh 'terraform init'
                }
            }
        }
        stage('Terraform validate') {
            steps {
                dir('terraform/infra') {
                    sh 'terraform validate'
                }
            }
        }
        stage('Terraform destroy') {
            steps {
                dir('terraform/schemas') {
                    withCredentials([
                        usernamePassword(credentialsId: 'confluent-cloud-creds', usernameVariable: 'CONFLUENT_CLOUD_API_KEY', passwordVariable: 'CONFLUENT_CLOUD_API_SECRET')
                    ]) {
                        sh "terraform destroy -auto-approve -state=/var/outputs/tf-schemas-${branchName}.tfstate"
                    }
                }
            }
        }
    }
}
