pipeline {
    agent any
    environment {
        AWS_DEFAULT_REGION="us-east-1"
        THE_BUTLER_SAYS_SO=credentials('aws-creds')
    }

    stages {
        stage('Build') {
            steps {
                sh 'aws --version'

            }
        }
        stage('s3') {
            steps {
                sh 'aws s3 ls'
            }
        }
        stage('check dockers version') {
            steps {
                sh 'docker --version'
            }
        }
    }
}
