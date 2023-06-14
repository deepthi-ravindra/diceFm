package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class Log {
    public static final Logger log = LogManager.getRootLogger();

    /**
     * Print a debug message
     *
     * @param message : The log4j debug to print
     */
    public static void debug(String message) {

        log.debug(message);
    }

    /**
     * Print an error message
     *
     * @param message : The log4j error to print
     */
    public static void error(String message) {

        log.error(message);
    }

    /**
     * Print an information message
     *
     * @param message : The log4j info to print
     */
    public static void info(String message) {

        log.info(message);
    }

    /**
     * Print a trace message
     *
     * @param message : The log4j trace to print
     */
    public static void trace(String message) {

        log.trace(message);
    }

    /**
     * Print a warning message
     *
     * @param message : The log4j warning to print
     */
    public static void warn(String message) {

        log.warn(message);
    }

    public static String getStackTrace(Exception ex) {
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        ex.printStackTrace(printWriter);
        return result.toString();
    }
}
