def run(String command, String directory = null) {
    logger.debug 'command: ' + command + ';' + 'directory: ' + directory
    String results
    try {
        if (directory != null) {
            if (fileExists(directory)) {
                dir(directory) {
                    results = runCommand(command)
                }
            }
        }
        else {
            logger.debug("Directory: ${directory} is not set.")
            results = runCommand(command)
        }
        logger.info(results)
    }
    catch (err) {
        logger.error(err)
        throw err
    }
}
