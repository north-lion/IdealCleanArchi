package ddd.domain.exceptions;

public class ServiceException extends Exception {
    boolean retryable;

    /**
     * Constructor
     */
    public ServiceException(final String message, final boolean retryable) {
        super(message);
        this.retryable = retryable;
    }

    public boolean isRetry() {
        return retryable;
    }
}
