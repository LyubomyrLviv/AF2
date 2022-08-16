package utility;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.ConsoleAppender;

public class Log {

    private static final Logger logger = LogManager.getLogger(Log.class);

    public static void main(String[] args) {

//        ConsoleAppender consoleAppender = new ConsoleAppender.Target();
        logger.info("logg some information");

//        logger.debug("Hello from Log4j 2");

        // in old days, we need to check the log level to increase performance
        /*if (logger.isDebugEnabled()) {
            logger.debug("{}", getNumber());
        }*/

        // with Java 8, we can do this, no need to check the log level
//        logger.debug("{}", () -> getNumber());

    }

//    static int getNumber() {
//        return 5;
//    }

}
