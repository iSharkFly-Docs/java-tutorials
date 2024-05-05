package com.ossez.jacksonjr;

import com.fasterxml.jackson.jr.ob.JSON;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * Create JSON String
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateJSONTest {

    @Test
    public void createJsonStringTest() throws IOException {
        System.out.println(JSON.std.with(JSON.Feature.PRETTY_PRINT_OUTPUT)
                .asString(new LinkedHashMap<String, Object>() {{
                    put("name", "John Doe");
                    put("age", 30);
                }}));
    }

}
