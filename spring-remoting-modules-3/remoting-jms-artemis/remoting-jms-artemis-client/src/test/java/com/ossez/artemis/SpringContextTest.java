package com.ossez.artemis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ossez.artemis.client.JmsArtemisClientApplication;

@SpringBootTest(classes = JmsArtemisClientApplication.class)
@RunWith(SpringRunner.class)
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
