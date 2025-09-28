package dev.raniery.quickevent.infra.adapter;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.entity.Event;
import dev.raniery.quickevent.infra.exceptions.NotFoundByIdException;
import dev.raniery.quickevent.infra.exceptions.NotFoundByTicketCodeException;
import dev.raniery.quickevent.infra.persistence.entity.EventEntity;
import dev.raniery.quickevent.infra.persistence.mapper.EventEntityMapper;
import dev.raniery.quickevent.infra.persistence.repository.EventRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventRepositoryAdapter implements EventAdapter {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    public EventRepositoryAdapter(EventRepository eventRepository, EventEntityMapper eventEntityMapper) {
        this.eventRepository = eventRepository;
        this.eventEntityMapper = eventEntityMapper;
    }

    @Override
    public Event createEvent(Event event) {
        EventEntity eventEntity = eventRepository.save(eventEntityMapper.toEntity(event));
        return eventEntityMapper.toDomain(eventEntity);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll().stream()
            .map(eventEntityMapper::toDomain)
            .toList();
    }

    // Other ways to check for ticket code existence
    @Override
    public boolean existsByTicketCode(String ticketCode) {
        return eventRepository.existsByTicketCode(ticketCode);
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
            .map(eventEntityMapper::toDomain)
            .orElseThrow(() -> new NotFoundByIdException("Event not found with id: " + id));
    }

    @Override
    public Event getEventByTicketCode(String ticketCode) {
        // Other way to find with Optional
        Optional<EventEntity> optionalEvent = eventRepository.findByTicketCode(ticketCode);

        if (optionalEvent.isPresent()) {
            return eventEntityMapper.toDomain(optionalEvent.get());
        }

        throw new NotFoundByTicketCodeException("Event not found with ticket code: " + ticketCode);
    }
}
