package dev.raniery.quickevent.infra.exceptions;

public class NotFoundByIdException extends RuntimeException {

    public NotFoundByIdException(String message) {
        super(message);
    }
}
