// myLocalLib.groovy
import groovy.yaml.YamlSlurper

def myFunction() {
    echo 'This is a function from my local Groovy library.'
}

def readYamlFile(String filename) {
    if (new File(filename).exists()) {
        return new YamlSlurper().parse(new File(filename))
    } else {
        logger.error("Config file not found: $filename")
    }
}

return this
