pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                echo 'Testing.'
            }
        }
    }
    post {
        always {
            junit 'build/reports/**/*.xml'
        }
    }
}