package com.ossez.junit5.spring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ossez.junit5.Greetings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringTestConfiguration.class })
public class GreetingsSpringUnitTest {

    @Test
    void whenCallingSayHello_thenReturnHello() {
        assertTrue("Hello".equals(Greetings.sayHello()));
    }

}