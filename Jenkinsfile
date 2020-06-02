pipeline {
  agent none

  environment {
    MAJOR_VERSION = 1
  }

  stages {
    stage('Unit Tests') {
      agent {
        label 'master'
      }
      steps {
        bat 'ant -f build_jenkins.xml -v'
        junit 'reports/TESTS-TestSuites.xml'
      }
    }
  }
}
