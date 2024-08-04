String repoPath = 'https://github.com/taicaile/Jenkinslib.git'
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
        String result = cmd 'ls -a'
        echo result
        myLocalLib.myFunction()
        // echo myLocalLib.readYamlFile('config.yaml')

        def config = readYaml(file: 'config.yaml')
        logger.info(config)
        echo config
    }

    stage('Test Library') {
        String result = cmd 'echo hello world'
        echo result
        logger.debug('This is a debug message.')
        logger.info 'This is a info message.'
        logger.warn 'This is a warn message.'
        logger.error 'This is a error message.'

        mylib.lib.Build.new().run(command = 'dir')
        iolib.Build.new().run(command = 'ls')
    }
}
