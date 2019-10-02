pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'export SEL_USERNAME=user19'
                sh 'export SEL_PASSWORD=CoolCanvas19.'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test -Dtest=LogoutTestCases'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
