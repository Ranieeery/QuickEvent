package dev.raniery.quickevent.core.entity;

import java.time.LocalDateTime;

public record Event(

    Long id,

    String name,

    String description,

    LocalDateTime startDateTime,

    LocalDateTime endDateTime,

    String location,

    Integer capacity,

    String organizer,

    Category category) {
}
