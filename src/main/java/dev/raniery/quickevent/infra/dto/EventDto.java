package dev.raniery.quickevent.infra.dto;

import dev.raniery.quickevent.core.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EventDto(
    @NotBlank
    String name,

    String description,

    @NotNull
    LocalDateTime startDateTime,

    @NotNull
    LocalDateTime endDateTime,

    @NotBlank
    String location,

    Integer capacity,

    String organizer,

    @NotNull
    Category category) {
}

