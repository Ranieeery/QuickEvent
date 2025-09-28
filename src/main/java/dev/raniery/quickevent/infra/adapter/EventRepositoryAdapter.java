package dev.raniery.quickevent.infra.adapter;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.entity.Event;
import dev.raniery.quickevent.infra.persistence.entity.EventEntity;
import dev.raniery.quickevent.infra.persistence.mapper.EventEntityMapper;
import dev.raniery.quickevent.infra.persistence.repository.EventRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
