package dev.raniery.quickevent.infra.config;

import dev.raniery.quickevent.infra.exceptions.TicketCodeMaxAttemptsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(TicketCodeMaxAttemptsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public String handleTicketCodeMaxAttemptsException(TicketCodeMaxAttemptsException e) {
        return e.getMessage();
    }
}
