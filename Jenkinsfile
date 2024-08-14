properties([disableConcurrentBuilds(),
            parameters([string(name: 'GOOGLE_CHAT_WEBDHOOK', trim: true)])
        ])

String libraryRepoURL = 'https://github.com/taicaile/Jenkinslib.git'
def mylib = library(identifier: 'mylib@main',
            retriever: modernSCM([$class: 'GitSCMSource', remote: "$libraryRepoURL"]),
            changelog: true)

// def locallib = mylib.core
def myLocalLib

node {
    stage('CheckEnv') {
        sh 'env'
    }

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
        echo config.toString()
        echo 'Config keys:'
        config.each { key ->
            echo "- $key, type: " + key.getClass().getName()
        }
    }

    stage('Test Library') {
        String result = cmd 'echo hello world'
        echo result
        logger.debug('This is a debug message.')
        logger.info 'This is a info message.'
        logger.warn 'This is a warn message.'
        logger.error 'This is a error message.'

        mylib.lib.Build.new().run(command = 'dir')
        locallib.Build.new().run(command = 'ls')
    }
}
