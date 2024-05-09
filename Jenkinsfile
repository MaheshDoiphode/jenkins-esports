pipeline {
    agent any
    tools {
        maven 'maven-3.9.6'
    }
    stages {
        stage('build') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }
        stage('Initialize') {
            steps {
                script {
                    def dockerHome = tool 'docker'
                    env.PATH = "${dockerHome}/bin:${env.PATH}"
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
