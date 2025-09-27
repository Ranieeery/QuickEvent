package dev.raniery.quickevent.infra.dto;

import dev.raniery.quickevent.core.enums.Category;

import java.time.LocalDateTime;

public record EventResponseDto(
    Long id,

    String name,

    String description,

    String ticketCode,

    LocalDateTime startDateTime,

    LocalDateTime endDateTime,

    String location,

    Integer capacity,

    String organizer,

    Category category) {
}