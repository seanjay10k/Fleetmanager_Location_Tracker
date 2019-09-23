node {
   stage('Preparation') { // for display purposes
      git 'https://github.com/jglick/simple-maven-project-with-tests.git'
   }
   stage('Build') { 
      sh "mvn package"
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts 'target/*.jar'
   }
}
