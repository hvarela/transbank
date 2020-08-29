package com.prueba.transbank.infrastructure.logger;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicSequenceConverter extends ClassicConverter {

    private AtomicLong sequenceNumber = new AtomicLong(0);

    @Override
    public String convert(ILoggingEvent event) {
        return Long.toString(sequenceNumber.getAndIncrement());
    }
}
