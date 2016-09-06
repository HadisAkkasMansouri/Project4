package ir.dotin.utility;

import org.apache.log4j.Logger;

public class LoggerUtil {

    private static Logger logger = Logger.getLogger("Log");

    private LoggerUtil() {}

    public static Logger getLogger() {
        return logger;
    }
}
