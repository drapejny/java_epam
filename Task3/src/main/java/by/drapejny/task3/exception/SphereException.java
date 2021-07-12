package by.drapejny.task3.exception;

public class SphereException extends Exception {

    public SphereException() {
    }

    public SphereException(String message) {
        super(message);
    }

    public SphereException(String message, Throwable cause) {
        super(message, cause);
    }

    public SphereException(Throwable cause) {
        super(cause);
    }

}
