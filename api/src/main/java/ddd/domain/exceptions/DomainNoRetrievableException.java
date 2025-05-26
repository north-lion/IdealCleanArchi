package ddd.domain.exceptions;

import ddd.domain.exceptions.base.BaseException;

/**
 * This exception is used when a no-revertible exception occurred.
 */
public class DomainNoRetrievableException extends BaseException {
    /**
     * Constructor
     */
    public DomainNoRetrievableException(final String message) {
        super(message);
    }
}
