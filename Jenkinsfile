pipeline {
    agent any

    tools {
        maven 'maven 3.8.4'
        jdk 'OpenJDK-11'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean install'
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