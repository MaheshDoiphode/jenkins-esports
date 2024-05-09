pipeline {
    agent any
    tools {
        maven 'maven-3.9.6'
        docker 'docker'
    }
    stages {
        // stage('Initialize') {
        //     steps {
        //         script {
        //             def dockerHome = tool 'docker'
        //             env.PATH = "${dockerHome}/bin:${env.PATH}"
        //         }
        //     }
        // }
        stage('testDocker'){
            steps{
                script{
                    sh 'docker --version'
                }
            
            }
        }
        stage('build') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }
        
        stage('dockerbuild') {
            steps {
                script {
                    sh 'docker build -t jenkins-esports .'
                }
            }
        }
        stage('pushDockerImage') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerpwd', variable: 'dockerpwd')]) {
                        sh "docker login -u mahesh324 -p ${dockerpwd}"
                        sh 'docker push mahesh324/jenkins-es-pipeline'
                    }
                }
            }
        }
    }
}
