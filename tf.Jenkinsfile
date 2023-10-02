pipeline {
    agent any 
    environment {
        CONFLUENT_CLOUD_API_KEY = credentials('CONFLUENT_CLOUD_API_KEY')
        CONFLUENT_CLOUD_API_SECRET = credentials('CONFLUENT_CLOUD_API_SECRET')
    }

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
                    sh "terraform apply -auto-approve -state=/var/outputs/tf-${env.BRANCH_NAME}.tfstate"
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
