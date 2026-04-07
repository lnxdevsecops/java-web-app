package com.example.webapp.testsupport;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

/**
 * Attaches a test appender to the Log4j {@link LoggerConfig} for a given class.
 */
public final class Log4jTestSupport {

    private Log4jTestSupport() {
    }

    public static void attachAppender(CapturingAppender appender, Class<?> loggedClass, Level level) {
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        String loggerName = LogManager.getLogger(loggedClass).getName();
        LoggerConfig loggerConfig = config.getLoggerConfig(loggerName);
        appender.start();
        loggerConfig.addAppender(appender, level, null);
        ctx.updateLoggers();
    }

    public static void detachAppender(CapturingAppender appender, Class<?> loggedClass) {
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        String loggerName = LogManager.getLogger(loggedClass).getName();
        LoggerConfig loggerConfig = config.getLoggerConfig(loggerName);
        loggerConfig.removeAppender(appender.getName());
        appender.stop();
        ctx.updateLoggers();
    }
}
