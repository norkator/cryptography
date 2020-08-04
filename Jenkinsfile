pipeline {
  agent none

  environment {
    MAJOR_VERSION = 1
    JAVA_HOME = "C:/Program Files/Java/jdk1.7.0_76"
  }

  stages {
    stage('Unit Tests') {
      agent {
        label 'master'
      }
      steps {
        bat 'ant -f build_jenkins.xml -v'
        junit 'junit/TESTS-TestSuites.xml'
      }
    }
  }
}
