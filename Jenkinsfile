pipeline {
    agent any 

    tools {
        maven 'Maven 3.9.4' 
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
                sh """
                    cd centralized-schema-management
                    ls -al
                """
                sh 'mvn clean install'
            }
        }
    }
}
