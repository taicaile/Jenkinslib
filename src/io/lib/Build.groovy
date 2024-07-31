
package lib.io

def build(String command, String directory){

    log.debug 'command: ' + command + ";" + 'directory: ' + directory

    try {
        if(directory){
            dir(directory){
                cmd command
            }
        }
        else{
            log.debug("Directory: ${directory} is not found.")
        }
    }
    catch (e) {
        throw e
    }
}