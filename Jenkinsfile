pipeline {
    agent any 

    tools {
        maven 'Maven 3.8.1' 
        jdk 'JDK 11'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm 
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Deploy') {
            steps {
                // sh './deploy.sh'
            }
        }
    }
}
