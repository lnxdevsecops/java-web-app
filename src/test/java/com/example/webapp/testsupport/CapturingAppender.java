package com.example.webapp.testsupport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;

/**
 * Collects Log4j events for assertions in tests (Log4j 2 {@link AbstractAppender}).
 */
public final class CapturingAppender extends AbstractAppender {

    private final List<LogEvent> events = new ArrayList<>();

    public CapturingAppender(String name) {
        super(name, null, null, true, Property.EMPTY_ARRAY);
    }

    @Override
    public void append(LogEvent event) {
        synchronized (events) {
            events.add(event.toImmutable());
        }
    }

    public void clear() {
        synchronized (events) {
            events.clear();
        }
    }

    public List<String> getFormattedMessages() {
        synchronized (events) {
            return events.stream()
                    .map(e -> e.getMessage().getFormattedMessage())
                    .collect(Collectors.toUnmodifiableList());
        }
    }

    public List<LogEvent> getEvents() {
        synchronized (events) {
            return List.copyOf(events);
        }
    }
}
