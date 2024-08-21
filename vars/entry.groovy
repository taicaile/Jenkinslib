import parser.ConfigParser

def call(String configFile) {
    def config = readYaml file: configFile

    def projectConfig = ConfigParser.new().parse(config)

    logger.info("from entry: ${projectConfig}")
}
