package com.isharkfly.xml.attribute;

import com.isharkfly.xml.attribute.JaxpTransformer;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.xmlunit.assertj.XmlAssert.assertThat;

/**
 * Unit test for {@link JaxpTransformer}.
 */
public class JaxpProcessorUnitTest {

    @Test
    public void givenXmlWithAttributes_whenModifyAttribute_thenGetXmlUpdated() throws IOException, SAXException, ParserConfigurationException, XPathExpressionException, TransformerFactoryConfigurationError, TransformerException {
        String path = getClass().getResource("/xml/attribute.xml")
            .toString();
        JaxpTransformer transformer = new JaxpTransformer(path);
        String attribute = "customer";
        String oldValue = "true";
        String newValue = "false";

        String result = transformer.modifyAttribute(attribute, oldValue, newValue);

        assertThat(result).hasXPath("//*[contains(@customer, 'false')]");
    }

    @Test
    public void givenXmlXee_whenInit_thenThrowException() throws IOException, SAXException, ParserConfigurationException, XPathExpressionException, TransformerFactoryConfigurationError, TransformerException {
        String path = getClass().getResource("/xml/xee_attribute.xml")
            .toString();

        assertThatThrownBy(() -> {

            new JaxpTransformer(path);

        }).isInstanceOf(SAXParseException.class);
    }

}
