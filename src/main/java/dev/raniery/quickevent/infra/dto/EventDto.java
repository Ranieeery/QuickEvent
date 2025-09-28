package dev.raniery.quickevent.infra.dto;

import dev.raniery.quickevent.core.enums.Category;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EventDto(
    @NotBlank(message = "Event name cannot be blank")
    String name,

    String description,

    @FutureOrPresent(message = "Start date and time must be in the future")
    @NotNull(message = "Start date and time cannot be null")
    LocalDateTime startDateTime,

    @Future(message = "End date and time must be in the future")
    @NotNull(message = "End date and time cannot be null")
    LocalDateTime endDateTime,

    @NotBlank(message = "Location cannot be blank")
    String location,

    Integer capacity,

    String organizer,

    @NotNull(message = "Category cannot be null")
    Category category) {
}

