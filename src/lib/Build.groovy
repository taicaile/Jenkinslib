package lib

def run(String command, String directory = null) {
    logger.debug 'command: ' + command + ';' + 'directory: ' + directory
    String results
    try {
        if (directory != null) {
            if(fileExists(directory)){
                dir(directory) {
                    results = cmd(command)
                }
            }
        }
        else {
            logger.debug("Directory: ${directory} is not set.")
            results = cmd(command)
        }
        logger.info(results)
    }
    catch (e) {
        logger.error(e)
        throw e
    }
}
