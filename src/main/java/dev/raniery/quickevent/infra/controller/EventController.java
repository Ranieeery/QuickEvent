package dev.raniery.quickevent.infra.controller;

import dev.raniery.quickevent.core.entity.Event;
import dev.raniery.quickevent.core.useCases.CreateEventCase;
import dev.raniery.quickevent.infra.dto.EventDto;
import dev.raniery.quickevent.infra.dto.EventResponseDto;
import dev.raniery.quickevent.infra.persistence.mapper.EventMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO: Add exception handling
//TODO: Add validation
@RestController
@RequestMapping("/api/v1")
public class EventController {

    private final EventMapper eventMapper;

    private final CreateEventCase createEventCase;

    public EventController(EventMapper eventMapper, CreateEventCase createEventCase) {
        this.eventMapper = eventMapper;
        this.createEventCase = createEventCase;
    }

    @PostMapping("/events")
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody EventDto eventDto) {
        Event newEvent = createEventCase.execute(eventMapper.toDomain(eventDto));

        return ResponseEntity.status(201).body(eventMapper.toResponseDto(newEvent));
    }
}
