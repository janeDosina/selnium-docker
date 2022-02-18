// pipeline {
//     agent any
//     stages {
//         stage('Build Jar') {
//             steps {
//                 sh "mvn clean package -DskipTests"
//             }
//         }
//         stage('Build Image') {
//             steps {
//                 sh "docker build -t='janeuniqacc/selenium-docker' ."
//             }
//         }
//         stage('Push Image') {
//             steps {
// 			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
//                     //sh
// 			        bat "docker login --username=${user} --password=${pass}"
// 			        bat "docker push vinsdocker/selenium-docker:latest"
// 			    }
//             }
//         }
//     }
// }

pipeline {
    agent none
    stages {
        stage('Build Jar') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                	app = docker.build("janeuniqacc/selenium-docker")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}
