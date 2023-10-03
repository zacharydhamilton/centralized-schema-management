pipeline {
    agent any 
    
    tools {
        terraform 'terraform'
    }

    stages {
        stage('Terraform destroy') {
            steps {
                dir('terraform/infra') {
                    withCredentials([
                        usernamePassword(credentialsId: 'confluent-cloud-creds', usernameVariable: 'CONFLUENT_CLOUD_API_KEY', passwordVariable: 'CONFLUENT_CLOUD_API_SECRET')
                    ]) {
                        sh "terraform destroy -auto-approve -state=/var/outputs/tf-infra-main.tfstate"
                    }
                }
            }
        }
    }
}
