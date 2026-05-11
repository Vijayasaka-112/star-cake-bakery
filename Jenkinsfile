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
        sh '''
            docker stop cake-app || true
            docker rm cake-app || true
            docker run -d --name cake-app -p 8081:8080 star-cake-bakery:v1
        '''
    }
}

     stage('Prometheus') {
    steps {
        sh '''
            docker rm -f prometheus || true
            docker run -d --name prometheus -p 9090:9090 \
            -v /var/lib/jenkins/workspace/cake-pipeline/prometheus/prometheus.yml:/etc/prometheus/prometheus.yml \
            prom/prometheus
        '''
    }
}
       stage('Grafana') {
    steps {
        sh '''
            docker rm -f grafana || true
            docker run -d --name grafana -p 3000:3000 grafana/grafana
        '''
    }
}

    post {
        always {
            echo 'Pipeline execution completed'
        }
    }
}
