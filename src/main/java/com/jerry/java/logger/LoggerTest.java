package com.jerry.java.logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

public class LoggerTest {

    private static final String logClass = LoggerTest.class.getName();
    private static final String logMethod = "testlogmain";
    private static final Logger log = Logger.getLogger(logClass);

    public static void main(String[] args) throws IOException {
//        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().setLevel(Level.ALL);
        Logger.getGlobal().info("global logger");
        log.info("industrial strength");
        log.entering(logClass, logMethod, "enter");
        log.exiting(logClass, logMethod, "exiting");
        log.throwing(logClass, "main", new RuntimeException("test"));

        System.out.println("========================");

        Logger logger = Logger.getLogger("com.mycompany.myapp");
        logger.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);
        logger.addHandler(handler);
        logger.fine("fine test");
        FileHandler fileHandler = new FileHandler();//日志默认输出到用户主目录的 javan.log 文件中，n 是文件名的唯一编号。
        logger.addHandler(fileHandler);
        logger.fine("file handler test");

        if (System.getProperty("java.util.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null) {
            try {
                Logger.getLogger("").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler1 = new FileHandler("%h/myapp.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("").addHandler(handler1);
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Can't create log file handler", e);
            }
        }
        System.out.println("-------------------------");
        //OFF, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST, ALL
        Logger logger1 = Logger.getLogger("com.mycompany.myapp");
        logger1.severe("severe");
        logger1.warning("warning");
        logger1.info("info");
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");

//        Thread.dumpStack();

        System.out.println("======================");
        StringWriter out = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(out));
        String description = out.toString();
        System.out.println("test stacktrace:" + description);

        Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    public void uncaughtException(Thread t, Throwable e) {
                        // save infomation in log file
                        System.out.println("发生错误了，但是我自己捕获了。 thread:" + t.getName() + " throwable:" + e);
                    }
                }
        );
        throw new RuntimeException();
    }
}
