package dev.raniery.quickevent.infra.service;

import dev.raniery.quickevent.infra.persistence.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketCodeExistsById {

    private final EventRepository eventRepository;

    public TicketCodeExistsById(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public boolean execute(String ticketCode) {
        return eventRepository.existsByTicketCode(ticketCode);
    }
}
