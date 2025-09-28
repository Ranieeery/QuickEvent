package dev.raniery.quickevent.core.useCases;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.entity.Event;

public class GetEventByIdUseCaseImpl implements GetEventByIdUseCase {

    private final EventAdapter eventAdapter;

    public GetEventByIdUseCaseImpl(EventAdapter eventAdapter) {
        this.eventAdapter = eventAdapter;
    }

    @Override
    public Event execute(Long id) {
        return eventAdapter.getEventById(id);
    }
}
