pipeline {
    agent any

    stages {
        stage('Build') {
            tools {
		        maven "mvn3.3.9"
      		}
      		
            steps {
                echo "This time, the Maven version should be 3.3.9"
		        sh "mvn -version"
            	sh 'make'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
                      
            post{
	            mail bcc: '', body: 'hello', cc: '', from: '', replyTo: '', subject: 'Jenkins Email {BUILD_URL}', to: 'ankur.javatm@gmail.com'
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