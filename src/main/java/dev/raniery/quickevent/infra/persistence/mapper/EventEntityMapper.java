package dev.raniery.quickevent.infra.persistence.mapper;

import dev.raniery.quickevent.core.entity.Event;
import dev.raniery.quickevent.infra.persistence.entity.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public Event toDomain(EventEntity eventEntity) {
        return new Event(
            eventEntity.getId(),
            eventEntity.getName(),
            eventEntity.getDescription(),
            eventEntity.getTicketCode(),
            eventEntity.getStartDateTime(),
            eventEntity.getEndDateTime(),
            eventEntity.getLocation(),
            eventEntity.getCapacity(),
            eventEntity.getOrganizer(),
            eventEntity.getCategory()
        );
    }

    public EventEntity toEntity(Event event) {
        return new EventEntity(
            event.id(),
            event.name(),
            event.description(),
            event.ticketCode(),
            event.startDateTime(),
            event.endDateTime(),
            event.location(),
            event.capacity(),
            event.organizer(),
            event.category()
        );
    }
}
