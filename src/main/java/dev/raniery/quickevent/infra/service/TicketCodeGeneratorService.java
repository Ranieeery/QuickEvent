package dev.raniery.quickevent.infra.service;

import dev.raniery.quickevent.infra.exceptions.TicketCodeMaxAttemptsException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketCodeGeneratorService {

    private final TicketCodeExistsById ticketCodeExistsById;

    public TicketCodeGeneratorService(TicketCodeExistsById ticketCodeExistsById) {
        this.ticketCodeExistsById = ticketCodeExistsById;
    }

    public String execute() {
        int MAX_ATTEMPTS = 10;
        for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
            String ticketCode = generateCode();
            if (!ticketCodeExistsById.execute(ticketCode)) {
                return ticketCode;
            }
        }
        throw new TicketCodeMaxAttemptsException("Failed to generate unique ticket code after " + MAX_ATTEMPTS + " attempts");
    }

    private String generateCode() {
        return "EVT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}