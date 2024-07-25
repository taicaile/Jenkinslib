def myLocalLib
def log

@Library('jenkinslib') _

node {

    stage('Checkout') {
        checkout scm
        myLocalLib = load "myLocalLib.groovy"

        // 将本地库中的所有脚本加载到 Groovy 的 Binding 中
        def binding = this.getBinding()
        def loader = new GroovyClassLoader(this.class.classLoader)
        new File("$libraryPath/vars").eachFile { file ->
            if (file.name.endsWith('.groovy')) {
                def scriptClass = loader.parseClass(file)
                def scriptInstance = scriptClass.newInstance()
                binding.setVariable(scriptClass.simpleName, scriptInstance)
            }
        }

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
        // repoPath = "file:."
        // library identifier: 'jenkinslib@main',
        //         retriever: modernSCM([$class: 'GitSCMSource', remote: "$repoPath"]),
        //         changelog: true

        sh 'echo hello world'
        log.info "hello world"
        log.warn "hello world"
        log.error "hello world"
    }
}
