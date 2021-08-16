package by.slizh.tutorsweb.pool;

import by.slizh.tutorsweb.exception.DataBaseConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static final Logger logger = LogManager.getLogger();

    private static ConnectionPool instance;

    private static AtomicBoolean isCreated = new AtomicBoolean(false);

    private static final ReentrantLock locker = new ReentrantLock();

    private BlockingQueue<ProxyConnection> freeConnections;
    private BlockingQueue<ProxyConnection> givenAwayConnections;

    private static final int DEFAULT_POOL_SIZE = 32;
    private static final String PATH_TO_PROPERTIES = "database/pool.properties";

    private ConnectionPool() {
        Properties properties = new Properties();
        int poolSize = DEFAULT_POOL_SIZE;
        try (InputStream inputStream = ConnectionPool.class.getClassLoader().getResourceAsStream(PATH_TO_PROPERTIES)) {
            properties.load(inputStream);
            poolSize = Integer.parseInt((String) properties.get("poolSize"));
            freeConnections = new LinkedBlockingDeque<>(poolSize);
            givenAwayConnections = new LinkedBlockingDeque<>();
            for (int i = 0; i < poolSize; i++) {
                ProxyConnection proxyConnection = (ProxyConnection) ConnectionCreator.createConnection();
                freeConnections.offer(proxyConnection);
            }
        } catch (IOException e) {
            logger.warn("Property file not found, used default poolSize: ", poolSize, e);
        } catch (DataBaseConnectionException e) {
            logger.fatal("Create connection error: ", e);
            throw new RuntimeException();
        }
    }

    public static ConnectionPool getInstance() {
        if (!isCreated.get()) {
            locker.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool();
                    isCreated.set(true);
                }
            } finally {
                locker.unlock();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        ProxyConnection proxyConnection = null;
        try {
            proxyConnection = freeConnections.take();
            givenAwayConnections.offer(proxyConnection);
        } catch (InterruptedException e) {
            logger.error("Interrapted while waiting: ", e);
            Thread.currentThread().interrupt();
        }
        return proxyConnection;
    }

    public void releaseConnection(Connection connection) {
        if (connection.getClass() == ProxyConnection.class) {
            givenAwayConnections.remove(connection);
            freeConnections.offer((ProxyConnection) connection);
        } else {
            logger.fatal("Wrong connection is detected, expected ProxyConnection object");
            throw new RuntimeException();
        }
    }

    public void destroyPool() {
        for (int i = 0; i < freeConnections.size(); i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (SQLException e) {
                logger.error("Close connection when destroying pool", e);
            } catch (InterruptedException e) {
                logger.error("Interrapted while waiting: ", e);
                Thread.currentThread().interrupt();
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("Exception when deregistering driver ", driver, e);
            }
        });
    }


}
