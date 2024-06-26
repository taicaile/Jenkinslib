node {
    checkout scm
    //   library identifier: "syndesis-pipeline-library@${env.BRANCH_NAME}", retriever: workspaceRetriever("${WORKSPACE}")
    repoPath = "https://github.com/tracetronic/jenkins-library.git"
    library identifier: 'jenkinslib@main',
            retriever: modernSCM([$class: 'GitSCMSource', remote: "$repoPath"]),
            changelog: false

    sh 'echo hello world'
    log.info "hello world"
}
