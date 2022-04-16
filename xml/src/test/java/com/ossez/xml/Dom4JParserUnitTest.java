package com.ossez.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 *
 */
public class Dom4JParserUnitTest {
    private static final Logger logger = LoggerFactory.getLogger(Dom4JParserUnitTest.class);

    final String fileName = "src/test/resources/example_dom4j.xml";

    Dom4JParser parser;

    @Test
    public void getRootElementTest() {
        parser = new Dom4JParser(new File(fileName));
        Element root = parser.getRootElement();

        assertNotNull(root);
        assertTrue(root.elements().size() == 4);
    }

    @Test
    public void getFirstElementListTest() {
        parser = new Dom4JParser(new File(fileName));
        List<Element> firstList = parser.getFirstElementList();

        assertNotNull(firstList);
        assertTrue(firstList.size() == 4);
        assertTrue(firstList.get(0).attributeValue("type").equals("java"));
    }

    @Test
    public void getElementByIdTest() {
        parser = new Dom4JParser(new File(fileName));
        Node element = parser.getNodeById("03");

        String type = element.valueOf("@type");
        assertEquals("android", type);
    }

    @Test
    public void getElementsListByTitleTest() {
        parser = new Dom4JParser(new File(fileName));
        Node element = parser.getElementsListByTitle("XML");

        assertEquals("java", element.valueOf("@type"));
        assertEquals("02", element.valueOf("@tutId"));
        assertEquals("XML", element.selectSingleNode("title").getText());
        assertEquals("title", element.selectSingleNode("title").getName());
    }

    @Test
    public void generateModifiedDocumentTest() {
        parser = new Dom4JParser(new File(fileName));
        parser.generateModifiedDocument();

        File generatedFile = new File("src/test/resources/example_dom4j_updated.xml");
        assertTrue(generatedFile.exists());

        parser.setFile(generatedFile);
        Node element = parser.getNodeById("02");

        assertEquals("XML updated", element.selectSingleNode("title").getText());

    }

    @Test
    public void generateNewDocumentTest() {
        parser = new Dom4JParser(new File(fileName));
        parser.generateNewDocument();

        File newFile = new File("src/test/resources/example_dom4j_new.xml");
        assertTrue(newFile.exists());

        parser.setFile(newFile);
        Node element = parser.getNodeById("01");

        assertEquals("XML with Dom4J", element.selectSingleNode("title").getText());
    }

    /**
     * testCreateXMLFromSystemProperties
     */
    @Test
    public void testCreateXMLFromSystemProperties() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("system");

        Properties properties = System.getProperties();
        for (Enumeration elements = properties.propertyNames(); elements
                .hasMoreElements(); ) {
            String name = (String) elements.nextElement();
            String value = properties.getProperty(name);
            Element element = root.addElement("property");
            element.addAttribute("name", name);
            element.addText(value);
        }

        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");

            Writer out = new StringWriter();
            XMLWriter writer = new XMLWriter(out, format);
            writer.write(document);
            writer.close();
            logger.debug("{}", out);

        } catch (IOException e) {
            logger.error("Write XML Error.", e);
        }
    }
}
