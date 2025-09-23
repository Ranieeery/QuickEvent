package dev.raniery.quickevent.infra.dto;

import dev.raniery.quickevent.core.enums.Category;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EventDto(
    String name,

    String description,

    LocalDateTime startDateTime,

    LocalDateTime endDateTime,

    String location,

    Integer capacity,

    String organizer,

    Category category) {
}
