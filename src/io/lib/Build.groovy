package io.lib

def build(String command, String directory = null){

    logger.debug 'command: ' + command + ";" + 'directory: ' + directory
    def results
    try {
        if(directory){
            dir(directory){
                results = cmd command
            }
        }
        else{
            logger.debug("Directory: ${directory} is not set.")
            results = cmd command
        }
        logger.info(results)
    }
    catch (e) {
        throw e
    }
}
