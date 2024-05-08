pipeline {
    agent any
    tools {
        maven 'maven-3.9.6'
    }
    stage('build') {
        steps {
            script {
                git 'https://github.com/MaheshDoiphode/jenkins-esports'
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
                    sh "docker login -u mahesh324 -p $dockerpwd"
                    sh 'docker push mahesh324/jenkins-es-pipeline'
                }
            }
        }
    }
}
