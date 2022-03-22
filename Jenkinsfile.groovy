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
        stage('lanch EC2') {
            steps {
                sh 'aws ec2 run-instances --image-id ami-01896de1f162f0ab7 --count 1 --instance-type t2.micro --key-name remote-key --security-group-ids sg-0ca1a0c086195ce85 --subnet-id subnet-0165069b503b96a38'
            }
        }
        // stage('check route53') {
        //     steps {
        //         sh 'aws route53 list-hosted-zones'
        //     }
        // }
    }
}
