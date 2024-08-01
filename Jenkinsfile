
def repoPath = 'https://github.com/taicaile/Jenkinslib.git'
def mylib = library(identifier: 'locallib@main',
            retriever: modernSCM([$class: 'GitSCMSource', remote: "$repoPath"]),
            changelog: true)

def iolib = mylib.lib

def myLocalLib

node {
    stage('Checkout') {
        checkout scm
        myLocalLib = load 'myLocalLib.groovy'
    }

    stage('Use Local Library') {
        def result = cmd 'ls -a'
        echo result
        myLocalLib.myFunction()
    }

    stage('Test Library') {
        def result = cmd 'echo hello world'
        echo result
        logger.debug("Hello World")
        logger.info "Hello World"
        logger.warn "Hello World"
        logger.error "Hello World"

        mylib.lib.Build.new().build(command = 'dir')
        iolib.Build.new().build(command = 'ls -a')
    }
}
