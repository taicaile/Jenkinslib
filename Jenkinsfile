def myLocalLib
def repoPath = "https://github.com/taicaile/Jenkinslib.git"

library identifier: 'locallib@main',
        retriever: modernSCM([$class: 'GitSCMSource', remote: "$repoPath"]),
        changelog: true

node {
    stage('Checkout') {
        checkout scm
        myLocalLib = load "myLocalLib.groovy"
        }

    stage('Use Local Library') {
        cmd("ls -a")
        myLocalLib.myFunction()
    }

    stage('Test Library'){
        cmd("echo hello world")
        logger.info "hello world"
        logger.warn "hello world"
        logger.error "hello world"
    }
}
