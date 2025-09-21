package dev.raniery.quickevent.core.entity;

import dev.raniery.quickevent.core.enums.Category;

import java.time.LocalDateTime;

public record Event(

    Long id,

    String name,

    String description,

    String eventTicketId,

    LocalDateTime startDateTime,

    LocalDateTime endDateTime,

    String location,

    Integer capacity,

    String organizer,

    Category category) {
}
