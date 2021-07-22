package by.drapejny.task2.builder;

import by.drapejny.task2.exception.FlowerException;
import by.drapejny.task2.handler.FlowerErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxFlowerBuilder extends AbstractFlowerBuilder {

    private FlowerHandler handler = new FlowerHandler();
    private XMLReader reader;

    public SaxFlowerBuilder() throws FlowerException {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        reader.setErrorHandler(new FlowerErrorHandler());
        reader.setContentHandler(handler);
    }

    @Override
    public void buildFlowers(String xmlPath) {
        try {
            reader.parse(xmlPath);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }

      flowers = handler.getFlowers();
    }
}
