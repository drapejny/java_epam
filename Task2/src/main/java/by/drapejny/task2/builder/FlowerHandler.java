package by.drapejny.task2.builder;

import by.drapejny.task2.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.Month;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class FlowerHandler extends DefaultHandler {
    private static final String UNDERSCORE = "_";
    private static final String HYPHEN = "-";
    private static final String ANNUAL_FLOWER_TAG = FlowerXmlTag.ANNUAL_FLOWER.getValue();
    private static final String PERENNUAL_FLOWER_TAG = FlowerXmlTag.PERENNUAL_FLOWER.getValue();
    private Set<Flower> flowers;
    private Flower currentFlower;
    private VisualAspect currentVisualAspect;
    private FlowerXmlTag currentXmlTag;
    private EnumSet<FlowerXmlTag> withText;
    private static final String ELEMENT_FLOWER = "flower";

    public FlowerHandler() {
        flowers = new HashSet<Flower>();
        withText = EnumSet.range(FlowerXmlTag.SIZE, FlowerXmlTag.FLOWERING_PERIOD);
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(ANNUAL_FLOWER_TAG) || qName.equals(PERENNUAL_FLOWER_TAG)) {
            currentFlower = qName.equals(ANNUAL_FLOWER_TAG) ? new AnnualFlower() : new PerennualFlower();
            currentFlower.setName(attributes.getValue(0));
            if (attributes.getLength() == 2) {
                currentFlower.setOrigin(attributes.getValue(1));
            }
        } else {
            if (qName.equals(FlowerXmlTag.VISUAL_ASPECT.getValue())) {
                currentVisualAspect = new VisualAspect();
            } else {
                String tempStr = qName.replace(HYPHEN, UNDERSCORE).toUpperCase();
                FlowerXmlTag temp = FlowerXmlTag.valueOf(tempStr);
                if (withText.contains(temp)) {
                    currentXmlTag = temp;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(ANNUAL_FLOWER_TAG) || qName.equals(PERENNUAL_FLOWER_TAG)) {
            flowers.add(currentFlower);
        }
        if (qName.equals(FlowerXmlTag.VISUAL_ASPECT.getValue())) {
            currentFlower.setVisualAspect(currentVisualAspect);
            currentVisualAspect = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        if(currentXmlTag != null) {
            switch (currentXmlTag) {
                case SIZE:
                    currentVisualAspect.setSize(Integer.parseInt(data));
                    break;
                case LEAVES_COLOR:
                    currentVisualAspect.setLeavesColor(data);
                    break;
                case BLOSSOM_COLOR:
                    currentVisualAspect.setBlossomColor(data);
                    break;
                case SOIL:
                    currentFlower.setSoil(Soil.valueOf(data));
                    break;
                case GROWING_TEMPERATURE:
                    currentFlower.setGrowingTemperature(Integer.parseInt(data));
                    break;
                case IS_LIGHT_LOVING:
                    currentFlower.setIsLightLoving(Boolean.parseBoolean(data));
                    break;
                case WATERING:
                    currentFlower.setWatering(Integer.parseInt(data));
                    break;
                case MULTIPLYING:
                    currentFlower.setMultiplying(Multiplying.valueOf(data));
                    break;
                case FLOWERING_PERIOD:
                    ((AnnualFlower) currentFlower).setFloweringPeriod(Month.valueOf(data));
                    break;
                case IS_WINTERING:
                    ((PerennualFlower) currentFlower).setIsWintering(Boolean.getBoolean(data));
                    break;
            }
        }
        currentXmlTag = null;
    }
}
