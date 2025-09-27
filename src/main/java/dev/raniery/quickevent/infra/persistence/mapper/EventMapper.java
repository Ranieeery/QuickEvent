package dev.raniery.quickevent.infra.persistence.mapper;

import dev.raniery.quickevent.core.entity.Event;
import dev.raniery.quickevent.infra.dto.EventDto;
import dev.raniery.quickevent.infra.dto.EventResponseDto;
import dev.raniery.quickevent.infra.service.TicketCodeGeneratorService;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public Event toDomain(EventDto eventDto) {
        return new Event(
            null,
            eventDto.name(),
            eventDto.description(),
            TicketCodeGeneratorService.execute(),
            eventDto.startDateTime(),
            eventDto.endDateTime(),
            eventDto.location(),
            eventDto.capacity(),
            eventDto.organizer(),
            eventDto.category()
        );
    }

    public EventDto toDto(Event event) {
        return EventDto.builder()
            .name(event.name())
            .description(event.description())
            .startDateTime(event.startDateTime())
            .endDateTime(event.endDateTime())
            .location(event.location())
            .capacity(event.capacity())
            .organizer(event.organizer())
            .category(event.category())
            .build();
    }

    public EventResponseDto toResponseDto(Event event) {
        return new EventResponseDto(
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
