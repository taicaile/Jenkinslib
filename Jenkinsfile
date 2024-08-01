
def repoPath = "https://github.com/taicaile/Jenkinslib.git"
def mylib = library(identifier: 'locallib@main',
            retriever: modernSCM([$class: 'GitSCMSource', remote: "$repoPath"]),
            changelog: true)

// import io.lib.Build
println mylib

def myLocalLib

println myUtils

node {
    stage('Checkout') {
        checkout scm
        myLocalLib = load "myLocalLib.groovy"
        }

    stage('Use Local Library') {
        def result = cmd "ls -a"
        echo result
        myLocalLib.myFunction()
    }

    stage('Test Library'){
        def result = cmd "echo hello world"
        echo result
        logger.info "hello world"
        logger.warn "hello world"
        logger.error "hello world"

        // def build = new Build()
        // build.("dir")
        mylib.io.lib.Build.build("dir")

    }
}
