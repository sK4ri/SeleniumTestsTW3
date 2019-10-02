pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn install clean'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test -Dtest=BrowseIssueTestCases'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
