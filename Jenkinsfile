node {
    stage('SCM Checkout') {
        
        git 'https://https://github.com/sK4ri/SeleniumTestsTw3'
    }
    stage('Compile-Package') {
        def mvnHome = tool name: 'maven-3', type: 'maven'
        sh "${mvnHome}/bin/mvn package"
    }
}
        
