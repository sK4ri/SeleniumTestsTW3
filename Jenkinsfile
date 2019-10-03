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
        stage('Run tests') {

                    parallel {

                                stage("User login test") {
                                    steps {
                                        echo 'Testing login...'
                                        sh 'mvn test -Dtest=LoginTestCases'
                                    }
                                }

                                stage("Browse Issues test") {
                                    steps {
                                        echo 'Testing browse issues...'
                                        sh 'mvn test -Dtest=BrowseIssueTestCases'
                                    }
                                }

                            }

                }

        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
