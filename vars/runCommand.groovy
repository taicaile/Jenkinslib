/**
 * Executes a passed command on Linux Shell or Windows Batch depending on the node.
 *
 * @param cmd
 *      the command to be executed
 */
def call(String cmd) {
    String result
    if (isUnix()) {
        logger.debug("received sh cmd: ${cmd}")
        result = sh script: "${cmd}", returnStdout: true
    } else {
        logger.debug("received bat cmd: ${cmd}")
        result = bat script: "@echo off\r\n${cmd}", returnStdout: true
    }
    return result
}
