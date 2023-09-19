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
                csh ' cd centralized-schema-management'
                sh 'mvn clean install'
            }
        }
    }
}
