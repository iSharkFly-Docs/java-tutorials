package com.ossez.multiline;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MultiLineStringUnitTest {


    @Test
    public void whenCompareMultiLineStrings_thenTheyAreAllTheSame() throws IOException {
        MultiLineString ms = new MultiLineString();
        assertEquals(ms.stringConcatenation(), ms.stringJoin());
        assertEquals(ms.stringJoin(), ms.stringBuilder());
        assertEquals(ms.stringBuilder(), ms.guavaJoiner());
        assertEquals(ms.guavaJoiner(), ms.loadFromFile());

//        Due to JDK version, we cannot test TestBlocks
//        assertEquals(ms.loadFromFile(), ms.textBlocks());
    }
    @Test
    public void newlineInOS() throws IOException {
        System.out.println(System.lineSeparator());
        System.out.println(System.getProperty("line.separator"));
    }
}
