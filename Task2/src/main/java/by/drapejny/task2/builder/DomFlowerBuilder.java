package by.drapejny.task2.builder;

import by.drapejny.task2.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.Month;

public class DomFlowerBuilder extends AbstractFlowerBuilder {

    private DocumentBuilder documentBuilder;

    public DomFlowerBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildFlowers(String xmlPath) {
        Document document;
        try {
            document = documentBuilder.parse(xmlPath);
            Element root = document.getDocumentElement();
            NodeList annualFlowersList = root.getElementsByTagName("annual-flower");
            NodeList perennualFlowersList = root.getElementsByTagName("perennual-flower");
            for (int i = 0; i < annualFlowersList.getLength(); i++) {
                Element element = (Element) annualFlowersList.item(i);
                Flower flower = buildFlower(element);
                flowers.add(flower);
            }
            for (int i = 0; i < perennualFlowersList.getLength(); i++) {
                Element element = (Element) perennualFlowersList.item(i);
                Flower flower = buildFlower(element);
                flowers.add(flower);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Flower buildFlower(Element element) {
        Flower flower = element.getTagName().equals("annual-flower") ? new AnnualFlower() : new PerennualFlower();
        flower.setName(element.getAttribute("name"));
        flower.setOrigin(element.getAttribute("origin"));
        Element visualAspectElement = (Element) element.getElementsByTagName("visual-aspect").item(0);
        int size = Integer.parseInt(getElementTextContent(visualAspectElement, "size"));
        String leaveColor = getElementTextContent(visualAspectElement, "leaves-color");
        String blossomColor = getElementTextContent(visualAspectElement, "blossom-color");
        flower.setVisualAspect(new VisualAspect(size, leaveColor, blossomColor));
        flower.setSoil(Soil.valueOf(getElementTextContent(element, "soil")));
        flower.setGrowingTemperature(Integer.parseInt(getElementTextContent(element, "growing-temperature")));
        flower.setIsLightLoving(Boolean.parseBoolean(getElementTextContent(element, "is-light-loving")));
        flower.setWatering(Integer.parseInt(getElementTextContent(element, "watering")));
        flower.setMultiplying(Multiplying.valueOf(getElementTextContent(element, "multiplying")));
        if (element.getTagName().equals("annual-flower")) {
            ((AnnualFlower) flower).setFloweringPeriod(Month.valueOf(getElementTextContent(element, "flowering-period")));
        } else {
            ((PerennualFlower) flower).setIsWintering(Boolean.parseBoolean(getElementTextContent(element, "is-wintering")));
        }
        return flower;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
