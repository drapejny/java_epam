package by.drapejny.task2.builder;

import by.drapejny.task2.exception.FlowerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FlowerBuilderFactory {

    private static final Logger logger = LogManager.getLogger();

    private FlowerBuilderFactory() {
    }

    private enum ParserType {
        SAX,
        STAX,
        DOM
    }

    public static AbstractFlowerBuilder createFlowerBuilder(String parserType) throws FlowerException {

        ParserType type = ParserType.valueOf(parserType.toUpperCase());

        switch (type) {
            case DOM:
                return new DomFlowerBuilder();
            case SAX:
                return new SaxFlowerBuilder();
            case STAX:
                return new StaxFlowerBuilder();
            default:
                logger.error("Illegal parser type: " + parserType);
                throw new FlowerException();
        }
    }
}
