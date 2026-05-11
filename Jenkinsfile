pipeline {
    agent any

    tools {
        maven 'maven3'
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t star-cake-bakery:v1 .'
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker stop $(docker ps -aq) || true'
                sh 'docker rm $(docker ps -aq) || true'
                sh 'docker run -d --name cake-app -p 8080:8080 star-cake-bakery:v1'
            }
        }

        stage('Prometheus') {
            steps {
                sh 'docker stop prometheus || true'
                sh 'docker rm prometheus || true'
                sh "docker run -d --name prometheus -p 9090:9090 -v \$WORKSPACE/prometheus/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus"
            }
        }

        stage('Grafana') {
            steps {
                sh 'docker stop grafana || true'
                sh 'docker rm grafana || true'
                sh 'docker run -d --name grafana -p 3000:3000 grafana/grafana'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed'
        }
    }
}
