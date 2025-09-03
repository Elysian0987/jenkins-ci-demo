pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'javac NumberAnalysis.java'
            }
        }
        stage('Test') {
            steps {
                sh 'java NumberAnalysis'
            }
        }
    }
}
