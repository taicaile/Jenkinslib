import parser.ConfigParser

def call(String configFile) {
    def config = readYaml file: configFile

    def projectConfig = ConfigParser.parse(config)

    logger.info("from entry: ${projectConfig}")
}
