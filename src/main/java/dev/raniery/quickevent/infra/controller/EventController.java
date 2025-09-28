package dev.raniery.quickevent.infra.controller;

import dev.raniery.quickevent.core.entity.Event;
import dev.raniery.quickevent.core.useCases.CreateEventUseCase;
import dev.raniery.quickevent.core.useCases.GetAllEventsUseCase;
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

    private final CreateEventUseCase createEventUseCase;

    private final GetAllEventsUseCase getAllEventsUseCase;

    public EventController(EventMapper eventMapper, CreateEventUseCase createEventUseCase, GetAllEventsUseCase getAllEventsUseCase) {
        this.eventMapper = eventMapper;
        this.createEventUseCase = createEventUseCase;
        this.getAllEventsUseCase = getAllEventsUseCase;
    }

    @PostMapping("/events")
    public ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody EventDto eventDto) {
        Event newEvent = createEventUseCase.execute(eventMapper.toDomain(eventDto));

        return ResponseEntity.status(201).body(eventMapper.toResponseDto(newEvent));
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventResponseDto>> getAllEvents() {
        List<EventResponseDto> eventList = getAllEventsUseCase.execute().stream().map(eventMapper::toResponseDto).toList();

        return ResponseEntity.ok(eventList);
    }
}
