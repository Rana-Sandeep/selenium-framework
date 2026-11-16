pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home'
        PATH = "${JAVA_HOME}/bin:/opt/homebrew/bin:${env.PATH}"
    }

    stages {
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/TEST-*.xml'
            archiveArtifacts artifacts: 'testing_screenshots/**', allowEmptyArchive: true
        }
    }
}