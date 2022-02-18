pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                sh "docker build -t='janeuniqacc/selenium-docker' ."
            }
        }
//         stage('Push Image') {
//             steps {
// 			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
//                     //sh
// 			        bat "docker login --username=${user} --password=${pass}"
// 			        bat "docker push vinsdocker/selenium-docker:latest"
// 			    }
//             }
//         }
    }
}