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

    public EventResponseDto toResponseDto(Event event) {
        return EventResponseDto.builder()
            .id(event.id())
            .name(event.name())
            .description(event.description())
            .ticketCode(event.ticketCode())
            .startDateTime(event.startDateTime())
            .endDateTime(event.endDateTime())
            .location(event.location())
            .capacity(event.capacity())
            .organizer(event.organizer())
            .category(event.category())
            .build();
    }
}
