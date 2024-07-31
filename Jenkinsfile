def myLocalLib
def repoPath = "https://github.com/taicaile/Jenkinslib.git"

library identifier: 'locallib@main',
        retriever: modernSCM([$class: 'GitSCMSource', remote: "$repoPath"]),
        changelog: false

node {

    stage('Checkout') {
        checkout scm
        myLocalLib = load "myLocalLib.groovy"
        }

    stage('Load Local Library') {
        sh "ls -a"
    }

    stage('Use Local Library') {
        myLocalLib.myFunction()
    }

    stage('Load Remote Lib'){
        // checkout scm
        // def repoPath = sh(returnStdout: true, script: 'pwd').trim()

        echo "${repoPath}"


        sh 'echo hello world'
        log.info "hello world"
        log.warn "hello world"
        log.error "hello world"
    }
}
