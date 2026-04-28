pipeline {
    agent any

    tools {
        maven 'maven3'
    }

    stages {

        stage('Git Clone') {
            steps {
                git 'https://github.com/yourusername/star-cake-bakery.git'
            }
        }

        stage('Build') {
            steps {
                dir('backend') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t star-cake-bakery:v1 .'
            }
        }

        stage('Deploy') {
            steps {
                sh 'kubectl apply -f deployment.yaml'
                sh 'kubectl apply -f service.yaml'
            }
        }
    }
}
