/* groovylint-disable DuplicateStringLiteral, GetterMethodCouldBeProperty, StaticMethodsBeforeInstanceMethods */
/**
 * Prints a formatted logging message to console output.
 *
 * For additional logging styles see <a href="http://misc.flogisoft.com/bash/tip_colors_and_formatting">
 *     Colors and formatting (ANSI/VT100 Control sequences)</a>.
 * <br>
 * <b>Prerequisite: <a href="https://plugins.jenkins.io/ansicolor/">ANSI Color Plugin</a></b>
 *
 * @param message
 *      the log message
 * @param color
 *      the font color (currently supported: {@code black (default), red, green, yellow, blue, magenta, cyan})
 * @param style
 *      the font style (currently supported: {@code normal (default), bold, underlined, reset (same as normal)})
 * @param prefix
 *      the prefix message (defaults to empty string)
 */
def toConsole(Object message, String color = 'black', String style = 'normal', String prefix = '') {
    def escapeCode = getEscapeCode()
    def colorCode = getColorCode(color)
    def styleCode = getStyleCode(style)
    def resetCode = getStyleCode('reset')
    ansiColor('xterm') {
        println "${escapeCode}${styleCode}${escapeCode}${colorCode}${prefix}${message}${escapeCode}${resetCode}"
    }
}

/**
 * Prints a formatted informative logging message to console output.
 *
 * @param logMessage
 *      the informative log message
 */
def info(Object logMessage) {
    toConsole(logMessage, 'cyan', 'normal', '[INFO]: ')
}

/**
 * Prints a formatted debug logging message to console output.
 *
 * <b>Precondition: environment variable <i>LOG_DEBUG</i> must be <i>true</i></b>
 *
 * @param debugMessage
 *      the debug log message
 */
def debug(Object debugMessage) {
    if (env.PIPELINE_LOGGER_DEBUG_MODE == 'true' || params.PIPELINE_LOGGER_DEBUG_MODE) {
        toConsole(debugMessage, 'blue', 'normal', '[DEBUG]: ')
    }
}

/**
 * Prints a formatted error logging message to console output.
 *
 * @param errorMessage
 *      the error log message
 */
def error(Object errorMessage) {
    toConsole(errorMessage, 'red', 'normal', '[ERROR]: ')
}

/**
 * Prints a formatted warning logging message to console output.
 *
 * @param warnMessage
 *      the warning log message
 */
def warn(Object warnMessage) {
    toConsole(warnMessage, 'yellow', 'normal', '[WARN]: ')
}

/**
 * Returns the ANSI code for a given color.
 *
 * @param color
 *      the color definition (currently supported: {@code black (default), red, green, yellow, blue, magenta, cyan})
 */
def getColorCode(String color) {
    def colorCode
    switch (color.toLowerCase()) {
        case 'black':
            colorCode = '30m'
            break
        case 'red':
            colorCode = '31m'
            break
        case 'green':
            colorCode = '32m'
            break
        case 'yellow':
            colorCode = '33m'
            break
        case 'blue':
            colorCode = '34m'
            break
        case 'magenta':
            colorCode = '35m'
            break
        case 'cyan':
            colorCode = '36m'
            break
        default:
            echo "WARN: Unknown font color '${color}', using default now."
            colorCode = '39m'
            break
    }
    return colorCode
}

/**
 * Returns the ANSI code for a given style.
 *
 * @param style
 *      the style definition (currently supported: {@code normal (default), bold, underlined, reset (same as normal)})
 */
def getStyleCode(String style) {
    def styleCode
    switch (style.toLowerCase()) {
        case 'bold':
            styleCode = '1m'
            break
        case 'underlined':
            styleCode = '4m'
            break
        case 'normal':
        case 'reset':
            styleCode = '0m'
            break
        default:
            echo "WARN: Unknown font style '${style}', using default now."
            styleCode = '0m'
            break
    }
    return styleCode
}

/**
 * Returns the ANSI escape sequence code.
 */
static getEscapeCode() {
    return '\u001B['
}
