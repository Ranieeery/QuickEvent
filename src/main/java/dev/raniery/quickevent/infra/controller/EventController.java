package dev.raniery.quickevent.infra.controller;

import dev.raniery.quickevent.core.entity.Event;
import dev.raniery.quickevent.core.useCases.CreateEventUseCase;
import dev.raniery.quickevent.core.useCases.GetAllEventsUseCase;
import dev.raniery.quickevent.core.useCases.GetEventByIdUseCase;
import dev.raniery.quickevent.core.useCases.GetEventByTicketCodeUseCase;
import dev.raniery.quickevent.infra.dto.EventDto;
import dev.raniery.quickevent.infra.dto.EventResponseDto;
import dev.raniery.quickevent.infra.persistence.mapper.EventMapper;
import dev.raniery.quickevent.infra.service.TicketCodeGeneratorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    private final EventMapper eventMapper;
    private final TicketCodeGeneratorService ticketCodeGeneratorService;

    private final CreateEventUseCase createEventUseCase;
    private final GetAllEventsUseCase getAllEventsUseCase;
    private final GetEventByIdUseCase getEventByIdUseCase;
    private final GetEventByTicketCodeUseCase getEventByTicketCodeUseCase;

    public EventController(EventMapper eventMapper, TicketCodeGeneratorService ticketCodeGeneratorService, CreateEventUseCase createEventUseCase, GetAllEventsUseCase getAllEventsUseCase, GetEventByIdUseCase getEventByIdUseCase, GetEventByTicketCodeUseCase getEventByTicketCodeUseCase) {
        this.eventMapper = eventMapper;
        this.ticketCodeGeneratorService = ticketCodeGeneratorService;
        this.createEventUseCase = createEventUseCase;
        this.getAllEventsUseCase = getAllEventsUseCase;
        this.getEventByIdUseCase = getEventByIdUseCase;
        this.getEventByTicketCodeUseCase = getEventByTicketCodeUseCase;
    }

    @PostMapping("/events")
    public ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody EventDto eventDto) {
        String ticketCode = ticketCodeGeneratorService.execute();

        Event newEvent = createEventUseCase.execute(eventMapper.toDomain(eventDto, ticketCode));
        URI uri = URI.create("/api/v1/events/" + newEvent.id());

        return ResponseEntity.created(uri).body(eventMapper.toResponseDto(newEvent));
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventResponseDto>> getAllEvents() {
        List<EventResponseDto> eventList = getAllEventsUseCase.execute().stream().map(eventMapper::toResponseDto).toList();

        return ResponseEntity.ok(eventList);
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable Long id) {
        Event event = getEventByIdUseCase.execute(id);

        return ResponseEntity.ok(eventMapper.toResponseDto(event));
    }

    @GetMapping("/events/ticket/{ticketCode}")
    public ResponseEntity<EventResponseDto> getEventByTicketCode(@PathVariable String ticketCode) {
        Event event = getEventByTicketCodeUseCase.execute(ticketCode);

        return ResponseEntity.ok(eventMapper.toResponseDto(event));
    }
}
