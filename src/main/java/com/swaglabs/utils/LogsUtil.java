package com.swaglabs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

public class LogsUtil {
    public static final String LOG_PATH = "test-outputs/Logs";
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LogsUtil.class);

    private LogsUtil(){
        super();
    }
    public static Logger logger(){
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }
    // LogsUtil.info
    public static void trace(String... message){
        logger().trace(String.join(" ",message));
    }
    public static void debug(String... message){
        logger().debug(String.join(" ",message));
    }
    public static void info(String... message){
        logger().info(String.join(" ",message));
    }
    public static void warn(String... message){
        logger().warn(String.join(" ",message));
    }
    public static void error(String... message){
        logger().error(String.join(" ",message));
    }
    public static void fatal(String... message){
        logger().fatal(String.join(" ",message));
    }














}
