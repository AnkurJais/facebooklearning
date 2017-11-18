pipeline {
    agent any

    stages {
        stage('Build') {
      		
            steps {
                echo "This time, the Maven version should be 3.3.9"
		        sh "mvn -version"
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
                      
            post{
            	success{
            		mail(from: "jenkins@ankur.com",body: "hello", subject: "Jenkins Email {BUILD_URL}", to: "ankur.javatm@gmail.com")
            	}
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}