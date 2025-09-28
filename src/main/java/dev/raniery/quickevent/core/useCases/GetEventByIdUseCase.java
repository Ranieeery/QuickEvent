package dev.raniery.quickevent.core.useCases;

import dev.raniery.quickevent.core.entity.Event;

public interface GetEventByIdUseCase {

    Event execute(Long id);
}
