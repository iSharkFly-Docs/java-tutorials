package com.baeldung.datetime;

import java.time.LocalDateTime;
import org.joda.time.DateTimeZone;
//import org.joda.time.format.ISODateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertInstantToTimestampUnitTest {

    private final static Logger logger = LoggerFactory.getLogger(ConvertInstantToTimestampUnitTest.class);

    @Test
    public void givenInstant_whenConvertedToTimestamp_thenGetTimestampWithSamePointOnTimeline() {
        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant); // same point on the time-line as Instant
        assertThat(instant.toEpochMilli()).isEqualTo(timestamp.getTime());

        instant = timestamp.toInstant();
        assertThat(instant.toEpochMilli()).isEqualTo(timestamp.getTime());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        formatter = formatter.withZone(TimeZone.getTimeZone("UTC").toZoneId());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        assertThat(formatter.format(instant)).isEqualTo(df.format(timestamp));
    }

}
