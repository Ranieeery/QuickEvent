package dev.raniery.quickevent.infra.controller;

import dev.raniery.quickevent.core.entity.Event;
import dev.raniery.quickevent.core.useCases.CreateEventCase;
import dev.raniery.quickevent.core.useCases.GetAllEventsCase;
import dev.raniery.quickevent.infra.dto.EventDto;
import dev.raniery.quickevent.infra.dto.EventResponseDto;
import dev.raniery.quickevent.infra.persistence.mapper.EventMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Add exception handling
@RestController
@RequestMapping("/api/v1")
public class EventController {

    private final EventMapper eventMapper;

    private final CreateEventCase createEventCase;

    private final GetAllEventsCase getAllEventsCase;

    public EventController(EventMapper eventMapper, CreateEventCase createEventCase, GetAllEventsCase getAllEventsCase) {
        this.eventMapper = eventMapper;
        this.createEventCase = createEventCase;
        this.getAllEventsCase = getAllEventsCase;
    }

    @PostMapping("/events")
    public ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody EventDto eventDto) {
        Event newEvent = createEventCase.execute(eventMapper.toDomain(eventDto));

        return ResponseEntity.status(201).body(eventMapper.toResponseDto(newEvent));
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventResponseDto>> getAllEvents() {
        List<EventResponseDto> eventList = getAllEventsCase.execute().stream().map(eventMapper::toResponseDto).toList();

        return ResponseEntity.ok(eventList);
    }
}
