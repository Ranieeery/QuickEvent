package dev.raniery.quickevent.infra.controller;

import dev.raniery.quickevent.core.entity.Event;
import dev.raniery.quickevent.core.useCases.CreateEventUseCase;
import dev.raniery.quickevent.core.useCases.GetAllEventsUseCase;
import dev.raniery.quickevent.infra.dto.EventDto;
import dev.raniery.quickevent.infra.dto.EventResponseDto;
import dev.raniery.quickevent.infra.persistence.mapper.EventMapper;
import dev.raniery.quickevent.infra.service.TicketCodeGeneratorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    private final EventMapper eventMapper;
    private final TicketCodeGeneratorService ticketCodeGeneratorService;

    private final CreateEventUseCase createEventUseCase;
    private final GetAllEventsUseCase getAllEventsUseCase;

    public EventController(EventMapper eventMapper, TicketCodeGeneratorService ticketCodeGeneratorService, CreateEventUseCase createEventUseCase, GetAllEventsUseCase getAllEventsUseCase) {
        this.eventMapper = eventMapper;
        this.ticketCodeGeneratorService = ticketCodeGeneratorService;
        this.createEventUseCase = createEventUseCase;
        this.getAllEventsUseCase = getAllEventsUseCase;
    }

    //TODO: findById to ResponseEntity.created() using URI
    @PostMapping("/events")
    public ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody EventDto eventDto) {
        String ticketCode = ticketCodeGeneratorService.execute();

        Event newEvent = createEventUseCase.execute(eventMapper.toDomain(eventDto, ticketCode));

        return ResponseEntity.status(201).body(eventMapper.toResponseDto(newEvent));
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventResponseDto>> getAllEvents() {
        List<EventResponseDto> eventList = getAllEventsUseCase.execute().stream().map(eventMapper::toResponseDto).toList();

        return ResponseEntity.ok(eventList);
    }
}
