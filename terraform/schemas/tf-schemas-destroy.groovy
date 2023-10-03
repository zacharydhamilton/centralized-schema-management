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
        stage('Terraform destroy') {
            steps {
                dir('terraform/schemas') {
                    withCredentials([
                        usernamePassword(credentialsId: 'confluent-cloud-creds', usernameVariable: 'CONFLUENT_CLOUD_API_KEY', passwordVariable: 'CONFLUENT_CLOUD_API_SECRET')
                    ]) {
                        sh "terraform destroy -auto-approve -state=/var/outputs/tf-${branchName}.tfstate"
                    }
                }
            }
        }
    }
}
