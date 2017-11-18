pipeline {
    agent any

	tools{
        maven "Maven 3.5.0" 
		jdk "jdk8"
	}
	
    stages {
    	stage('Initialize'){
			steps{
		    	sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
			}
    	}
    
        stage('Build') {
      		
            steps {
                echo "This time, the Maven version should be 3.3.9"
		        sh "mvn -version"
		        mvn exec:java -Dexec.mainClass="learning.jenkins.facebook"
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
                      
            post{
            	success{
            		mail(from: "jenkins@ankur.com",body: "hello", subject: "Jenkins Email ${BUILD_URL}", to: "ankur.javatm@gmail.com")
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