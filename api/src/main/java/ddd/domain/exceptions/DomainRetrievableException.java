package ddd.domain.exceptions;

import ddd.domain.exceptions.base.BaseException;
/**
 * This exception is used when a revertible exception occurred.
 */
public class DomainRetrievableException extends BaseException {
    /**
     * Constructor
     */
    public DomainRetrievableException(String message) {
        super(message);
    }
}