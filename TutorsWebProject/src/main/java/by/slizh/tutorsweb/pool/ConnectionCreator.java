package by.slizh.tutorsweb.pool;

import by.slizh.tutorsweb.exception.DataBaseConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {

    private static final Logger logger = LogManager.getLogger();

    private static final Properties properties = new Properties();
    private static final String PATH_TO_PROPERTIES = "database/connection.properties";
    private static final String DATABASE_URL;

    static {
        String driverName;
        try (InputStream inputStream = ConnectionCreator.class.getClassLoader().getResourceAsStream(PATH_TO_PROPERTIES)) {
            properties.load(inputStream);
            driverName = (String) properties.get("db.driver");
            DATABASE_URL = (String) properties.get("db.url");
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            logger.fatal("Register driver fatal error: ", e);
            throw new RuntimeException();
        } catch (IOException e) {
            logger.fatal("Load properties file error: ", e);
            throw new RuntimeException();
        }

    }

    private ConnectionCreator() {
    }

    public static Connection createConnection() throws DataBaseConnectionException {
        try {
            return DriverManager.getConnection(DATABASE_URL, properties);
        } catch (SQLException e) {
            logger.error("Can't connected to database by ULR: ", DATABASE_URL, e);
            throw new DataBaseConnectionException();
        }
    }
}

