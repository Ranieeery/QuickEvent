package dev.raniery.quickevent.infra.exceptions;

public class TicketCodeMaxAttemptsException extends RuntimeException {

    public TicketCodeMaxAttemptsException(String message) {
        super(message);
    }
}
