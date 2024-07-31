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

    stage('Load Local Library') {
        cmd "ls -a"
    }

    stage('Use Local Library') {
        myLocalLib.myFunction()
    }

    stage('Load Remote Lib'){
        // checkout scm
        // def repoPath = sh(returnStdout: true, script: 'pwd').trim()

        echo "${repoPath}"


        cmd 'echo hello world'
        logger.info "hello world"
        logger.warn "hello world"
        logger.error "hello world"
    }
}
