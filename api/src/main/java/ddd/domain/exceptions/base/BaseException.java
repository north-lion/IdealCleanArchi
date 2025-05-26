package ddd.domain.exceptions.base;

/**
 * This class is the base for any exception class that occurs in the domain.
 * When wrapping exceptions, avoid using this class and use an exception class that extends this class.
 */
public class BaseException extends Exception {
    /**
     * Constructor
     */
    public BaseException(final String message) {
        super(message);
    }
}
