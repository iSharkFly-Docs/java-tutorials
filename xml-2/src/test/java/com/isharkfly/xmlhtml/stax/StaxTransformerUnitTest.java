package com.isharkfly.xmlhtml.stax;

import com.isharkfly.xmlhtml.stax.StaxTransformer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class StaxTransformerUnitTest {

    @Disabled // JAVA-39223
    @Test
    public void givenXml_whenTransform_thenGetHtml() throws IOException, URISyntaxException, XMLStreamException {
        String path = "src/test/resources/xmlhtml/notification.xml";
        String expectedHtml = new String(Files.readAllBytes((Paths.get(getClass()
          .getResource("/xmlhtml/notification.html")
          .toURI()))));
        StaxTransformer transformer = new StaxTransformer(path);

        String result = transformer.html();

        assertThat(result).isEqualTo(expectedHtml);
    }

}
