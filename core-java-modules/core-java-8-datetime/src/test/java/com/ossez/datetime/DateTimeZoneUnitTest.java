package com.ossez.datetime;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTimeZoneUnitTest {
    private static final Logger logger = LoggerFactory.getLogger(DateTimeZoneUnitTest.class);

    @Test
    public void zoneId_out() {
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        logger.debug("zoneId: {}", zoneId);
    }


    @Test
    public void zoneOffset_out() {
        LocalDateTime now = LocalDateTime.now();
        ZoneId zone = ZoneId.of("Asia/Shanghai");
        ZoneOffset zoneOffSet = zone.getRules().getOffset(now);
        logger.debug("zoneOffSet: {}", zoneOffSet);
    }

    @Test
    public void ZonedDateTime_out() {
        ZoneId zone = ZoneId.of("Asia/Shanghai");
        ZonedDateTime date = ZonedDateTime.now(zone);
        logger.debug("date: {}", date);
    }
}