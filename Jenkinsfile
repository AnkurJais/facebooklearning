pipeline {
    agent any

    parameters {
        string(name: 'Email', defaultValue: 'ankur.javatm@gmail.com', description: 'Whom should I send the email?')
    }
    
	tools{
        maven "Maven 3.5.2" 
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
            echo "In Build Step"
	                echo "This time, the Maven version should be 3.3.9"    
			        sh	"mvn -version"
			        sh	"mvn clean"
			        sh	"mvn install"
			        sh	"mvn exec:java -Dexec.mainClass=learning.jenkins.facebook.Driver"
			        
	                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
                      
            post{
            	success{
            		mail(from: "jenkins@ankur.com",body: "hello", subject: "Jenkins Email ${BUILD_URL}", to: "${params.Email}")
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
