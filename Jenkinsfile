pipeline {
    agent any 

    tools {
        maven 'maven3.9.4' 
        jdk 'jdk11'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm 
            }
        }

        stage('Build and Test') {
            steps {
                dir('simple-app') {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Move JAR file') {
            steps {
                script {
                    sh 'mv simple-app/target/simple-app-*.jar /var/outputs/'
                }
            }
        }
    }
}
