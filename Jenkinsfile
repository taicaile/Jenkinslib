def myLocalLib
def log
node {

    stage('Checkout') {
        checkout scm
        myLocalLib = load "myLocalLib.groovy"
        log = load "log.groovy"
        }

    stage('Load Local Library') {
        sh "ls -a"
    }

    stage('Use Local Library') {
        myLocalLib.myFunction()
    }

    stage('Load Remote Lib'){
        // checkout scm
        // //   library identifier: "syndesis-pipeline-library@${env.BRANCH_NAME}", retriever: workspaceRetriever("${WORKSPACE}")
        // repoPath = "https://github.com/tracetronic/jenkins-library.git"
        // library identifier: 'jenkinslib@main',
        //         retriever: modernSCM([$class: 'GitSCMSource', remote: "$repoPath"]),
        //         changelog: false

        sh 'echo hello world'
        log.info "hello world"
        log.warn "hello world"
        log.error "hello world"
    }
}
