package com.ossez.artemis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ossez.artemis.server.JmsArtemisServerApplication;

/**
 * This Live Test requires:
 * * the `com.baeldung:remoting-http-api:jar:1.0-SNAPSHOT` artifact accessible. For that we can run `mvn clean install` in the 'spring-remoting/remoting-http/remoting-http-api' module.
 * * an ActiveMQ instance running (e.g. `docker run -p 61616:61616 -p 8161:8161 --name bael-activemq rmohr/activemq`)
 *
 */
@SpringBootTest(classes = JmsArtemisServerApplication.class)
@RunWith(SpringRunner.class)
public class SpringContextLiveTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
