pipeline {
    agent any

    tools {
        maven 'maven3'
    }

    stages {
stage('Git Clone') {
    steps {
        git branch: 'main',
        url: 'https://github.com/Vijayasaka-112/star-cake-bakery.git'
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
