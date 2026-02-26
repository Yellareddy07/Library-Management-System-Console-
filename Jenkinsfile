pipeline {
    agent any
    
    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/your-username/your-repo.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'echo "Add your build command here"'
            }
        }
        
        stage('Test') {
            steps {
                sh 'echo "Add your test command here"'
            }
        }
        
        stage('Deploy') {
            steps {
                sh 'echo "Add your deploy command here"'
            }
        }
    }
}
