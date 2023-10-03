pipeline {
    agent any 
    

    tools {
        terraform 'terraform'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                script {
                    branchName = scm.branches[0].name.replaceAll("origin/", "")
                }
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
                dir('terraform/schemas') {
                    withCredentials([
                        usernamePassword(credentialsId: 'confluent-cloud-creds', usernameVariable: 'CONFLUENT_CLOUD_API_KEY', passwordVariable: 'CONFLUENT_CLOUD_API_SECRET')
                    ]) {
                        sh "terraform apply -auto-approve -state=/var/outputs/tf-schemas-${branchName}.tfstate \
                        -var=\"env_id=$(terraform output -state=/var/outputs/tf-infra-main.tfstate -raw env_id)\" \
                        -var=\"sr_cluster_id=$(terraform output -state=/var/outputs/tf-infra-main.tfstate -raw sr_cluster_id)\" \
                        -var=\"app_manager_sr_key=$(terraform output -state=/var/outputs/tf-infra-main.tfstate -raw app_manager_sr_key)\" \
                        -var=\"app_manager_sr_secret=$(terraform output -state=/var/outputs/tf-infra-main.tfstate -raw app_manager_sr_secret)\""
                    }
                }
            }
        }
        stage('Trigger app build') {
            steps {
                build job: "app-branch-${branchName}", wait: false
            }
        }
    }
}
