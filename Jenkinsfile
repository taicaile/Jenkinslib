def myLocalLib
def log

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
        //   library identifier: "syndesis-pipeline-library@${env.BRANCH_NAME}", retriever: workspaceRetriever("${WORKSPACE}")
        def repoPath = sh(returnStdout: true, script: 'pwd').trim()

        library identifier: 'local-lib@main',
                retriever: modernSCM([$class: 'GitSCMSource', remote: "$repoPath"]),
                changelog: false

        sh 'echo hello world'
        log.info "hello world"
        log.warn "hello world"
        log.error "hello world"
    }
}
