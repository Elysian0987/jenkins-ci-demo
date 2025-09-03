pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'javac NumberAnalysis.java'
            }
        }
        stage('Test with Number Only') {
            steps {
                // Pass 5 as input argument
                sh 'java NumberAnalysis 5'
            }
        }
        stage('Test with Number + Output File') {
            steps {
                // Pass 7 as input and save results to output.txt
                sh 'java NumberAnalysis 7 output.txt'
                // Show contents of file in Jenkins logs
                sh 'cat output.txt'
            }
        }
    }
}
