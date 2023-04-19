pipeline {
    agent any
    tools {
        maven '3.9.0'
        jdk 'JDK 17.0.4.1'
    }
    stages {
        stage ('build maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'JDK 17.0.4.1', url: 'https://github.com/jm-jesusm/Stripe-users']])
                sh 'mvn clean install'
            }
        }
    }
}
