package dev.raniery.quickevent.infra.controller;

import dev.raniery.quickevent.infra.dto.EventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    @PostMapping("/events")
    public ResponseEntity<String> createEvent(@RequestBody EventDto eventDto) {
        return ResponseEntity.status(201).body("Event created successfully");
    }
}
