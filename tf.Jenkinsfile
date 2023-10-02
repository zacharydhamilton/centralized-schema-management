pipeline {
    agent any 

    tools {
        terraform 'terraform'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm 
            }
        }
        stage('Terraform init') {
            steps {
                dir('terraform') {
                    sh 'terraform init'
                }
            }
        }
        stage('Terraform validate') {
            steps {
                dir('terraform') {
                    sh 'terraform validate'
                }
            }
        }
        stage('Terraform apply') {
            steps {
                dir('terraform') {
                    withCredentials([
                        usernamePassword(credentialsId: 'confluent-cloud-creds', usernameVariable: 'CONFLUENT_CLOUD_API_KEY', passwordVariable: 'CONFLUENT_CLOUD_API_SECRET')
                    ]) {
                        sh "terraform apply -auto-approve -state=/var/outputs/tf-${env.BRANCH_NAME}.tfstate"
                    }
                }
            }
        }
        stage('Trigger app build') {
            steps {
                build job: "app-branch-${env.BRANCH_NAME}", wait: false
            }
        }
    }
}
