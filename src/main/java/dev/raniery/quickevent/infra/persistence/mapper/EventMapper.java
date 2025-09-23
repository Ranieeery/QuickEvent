package dev.raniery.quickevent.infra.persistence.mapper;

import dev.raniery.quickevent.core.entity.Event;
import dev.raniery.quickevent.infra.dto.EventDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EventMapper {

    //TODO: construtor para ID e ticketCode
    public Event toDomain(EventDto eventDto) {
        return new Event(
            null,
            eventDto.name(),
            eventDto.description(),
            null,
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
}
