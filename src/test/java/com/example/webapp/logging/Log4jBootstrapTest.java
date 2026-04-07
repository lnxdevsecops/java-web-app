package com.example.webapp.logging;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.webapp.service.ConsultingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.junit.jupiter.api.Test;

/**
 * Smoke tests that Log4j 2 loads and {@link Logger} instances resolve for application classes.
 */
class Log4jBootstrapTest {

    @Test
    void logManager_returnsLoggerForApplicationClass() {
        Logger log = LogManager.getLogger(ConsultingService.class);
        assertThat(log.getName()).isEqualTo(ConsultingService.class.getName());
        assertThat(log.isInfoEnabled()).isTrue();
    }

    @Test
    void loggerContext_isLog4jCoreImplementation() {
        assertThat(LogManager.getContext(false)).isInstanceOf(LoggerContext.class);
    }
}
