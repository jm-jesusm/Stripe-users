pipeline {
    agent any
    tools {
        maven 'mvn_3.9.1'
        jdk 'jdk_17'
    }
    stages {
        stage ('build maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '856c9102-8c01-40db-ae5d-680e1c95122d', url: 'https://github.com/jm-jesusm/Stripe-users']])
                sh 'mvn clean install'
            }
        }
    }
}
