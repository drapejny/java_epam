package by.drapejny.task2.builder;

import by.drapejny.task2.entity.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Month;

public class StaxFlowerBuilder extends AbstractFlowerBuilder {

    private static final String UNDERSCORE = "_";
    private static final String HYPHEN = "-";

    private XMLInputFactory inputFactory;

    public StaxFlowerBuilder() {
        super();
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildFlowers(String xmlPath) {
        XMLStreamReader reader;
        try (FileInputStream inputStream = new FileInputStream(new File(xmlPath))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    String name = reader.getLocalName();
                    if (name.equals(FlowerXmlTag.ANNUAL_FLOWER.getValue()) || name.equals(FlowerXmlTag.PERENNUAL_FLOWER.getValue())) {
                        Flower flower = buildFlower(reader);
                        flowers.add(flower);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public Flower buildFlower(XMLStreamReader reader) throws XMLStreamException {
        String name = reader.getLocalName();
        Flower flower = name.equals(FlowerXmlTag.ANNUAL_FLOWER.getValue()) ? new AnnualFlower() : new PerennualFlower();
        flower.setName(reader.getAttributeValue(null, FlowerXmlTag.NAME.getValue()));
        flower.setOrigin(reader.getAttributeValue(null, FlowerXmlTag.ORIGIN.getValue()));
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    name = name.replace(HYPHEN, UNDERSCORE).toUpperCase();
                    switch (FlowerXmlTag.valueOf(name)) {
                        case VISUAL_ASPECT:
                            flower.setVisualAspect(getVisualAspect(reader));
                            break;
                        case SOIL:
                            flower.setSoil(Soil.valueOf(getXmlContentText(reader)));
                            break;
                        case GROWING_TEMPERATURE:
                            flower.setGrowingTemperature(Integer.parseInt(getXmlContentText(reader)));
                            break;
                        case IS_LIGHT_LOVING:
                            flower.setIsLightLoving(Boolean.parseBoolean(getXmlContentText(reader)));
                            break;
                        case WATERING:
                            flower.setWatering(Integer.parseInt(getXmlContentText(reader)));
                            break;
                        case MULTIPLYING:
                            flower.setMultiplying(Multiplying.valueOf(getXmlContentText(reader)));
                            break;
                        case FLOWERING_PERIOD:
                            ((AnnualFlower) flower).setFloweringPeriod(Month.valueOf(getXmlContentText(reader)));
                            break;
                        case IS_WINTERING:
                            ((PerennualFlower) flower).setIsWintering(Boolean.parseBoolean(getXmlContentText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    name = name.replace(HYPHEN, UNDERSCORE).toUpperCase();
                    if (FlowerXmlTag.valueOf(name) == FlowerXmlTag.ANNUAL_FLOWER ||
                            FlowerXmlTag.valueOf(name) == FlowerXmlTag.PERENNUAL_FLOWER) {
                        return flower;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag <" + name + ">");
    }

    private VisualAspect getVisualAspect(XMLStreamReader reader) throws XMLStreamException {
        VisualAspect visualAspect = new VisualAspect();
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    name = name.replace(HYPHEN, UNDERSCORE).toUpperCase();
                    switch (FlowerXmlTag.valueOf(name)) {
                        case SIZE:
                            visualAspect.setSize(Integer.parseInt(getXmlContentText(reader)));
                            break;
                        case LEAVES_COLOR:
                            visualAspect.setLeavesColor(getXmlContentText(reader));
                            break;
                        case BLOSSOM_COLOR:
                            visualAspect.setBlossomColor(getXmlContentText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    name = name.replace(HYPHEN, UNDERSCORE).toUpperCase();
                    if (FlowerXmlTag.valueOf(name) == FlowerXmlTag.VISUAL_ASPECT) {
                        return visualAspect;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <visual-aspect>");
    }

    private String getXmlContentText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
