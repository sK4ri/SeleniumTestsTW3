pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn install clean'
                sh 'java -version'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                sh 'mvn test -Dtest=LoginTestCases'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
