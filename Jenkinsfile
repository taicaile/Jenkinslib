
properties([disableConcurrentBuilds(),
            parameters([
                string(name: 'PROJECT_GOOGLE_CHAT_WEBHOOK_URL', trim: true, description: 'Google Chat notification webhook url.'),
                booleanParam(name: 'PIPELINE_LOGGER_DEBUG_MODE', defaultValue: false, description: 'Print debug message')
            ])
        ])

String libraryRepoURL = 'https://github.com/taicaile/Jenkinslib.git'
def mylib = library(identifier: 'mylib@main',
            retriever: modernSCM([$class: 'GitSCMSource', remote: "$libraryRepoURL"]),
            changelog: true)

def corelib = mylib.core
def myLocalLib

node {
    stage('CheckEnv') {
        sh 'env'
        logger.info(mylib)
        logger.info(corelib)
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

        def config = readYaml(file: 'ci_proj_config.yaml')
        logger.info(config)
        logger.info('Config keys:')
        config.each { key ->
            logger.info("- $key, type: " + key.getClass().getName())
        }
    }

    stage('Test Library') {
        String result = cmd 'echo hello world'
        echo result
        logger.debug('This is a debug message.')
        logger.info 'This is a info message.'
        logger.warn 'This is a warn message.'
        logger.error 'This is a error message.'

        corelib.Build.new().run(command = 'dir')
        locallib.Build.new().run(command = 'ls')
    }
}
