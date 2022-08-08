package com.ossez.features;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class Template {

    private static final Clock clock = Clock.fixed(Instant.parse("2016-10-09T15:10:30.00Z"), ZoneId.of("UTC"));

}
