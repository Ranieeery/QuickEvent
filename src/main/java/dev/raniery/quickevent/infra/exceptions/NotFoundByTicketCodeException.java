package dev.raniery.quickevent.infra.exceptions;

public class NotFoundByTicketCodeException extends RuntimeException {

    public NotFoundByTicketCodeException(String message) {
        super(message);
    }
}
