pipeline {
    agent any

    parameters {
        string(name: 'Email', defaultValue: 'ankur.javatm@gmail.com', description: 'Whom should I send the email?')
    }
    
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
            	wrap([$class: 'Xvfb', screen: '1024x768x24', displayNameOffset: 99, installationName: 'default']) {
	                echo "This time, the Maven version should be 3.3.9"
			        sh "mvn -version"
			        sh "mvn exec:java -Dexec.mainClass=learning.jenkins.facebook"
	                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
	            }    
            }
                      
            post{
            	success{
            		mail(from: "jenkins@ankur.com",body: "hello", subject: "Jenkins Email ${BUILD_URL}", to: "${params.Greeting}")
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