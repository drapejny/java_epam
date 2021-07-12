package by.drapejny.task3.entity;

import by.drapejny.task3.exception.SphereException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class SphereWarehouse {

    private static final Logger logger = LogManager.getLogger();

    private static SphereWarehouse instance = null;

    private Map<Long, SphereParameter> parameters = new HashMap<>();

    private SphereWarehouse() {
    }

    public static SphereWarehouse getInstance() {
        if (instance == null) {
            instance = new SphereWarehouse();
        }
        return instance;
    }

    public SphereParameter put(Long id, SphereParameter value) {
        return parameters.put(id, value);
    }

    public SphereParameter get(Long id) throws SphereException {
        if (!parameters.containsKey(id)) {
            logger.error("Warehouse does not contains sphere with id {}", id);
            throw new SphereException();
        }
        return parameters.get(id);
    }

    public SphereParameter remove(Long id){
        return parameters.remove(id);
    }
}
