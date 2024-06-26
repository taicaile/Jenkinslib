node {
    checkout scm
    //   library identifier: "syndesis-pipeline-library@${env.BRANCH_NAME}", retriever: workspaceRetriever("${WORKSPACE}")
    repoPath = "jenkinslib"
    library identifier: 'jenkinslib@master',
            retriever: modernSCM([$class: 'GitSCMSource', remote: "$repoPath"]),
            changelog: false

    sh 'echo hello world'
    log.info "hello world"
}
