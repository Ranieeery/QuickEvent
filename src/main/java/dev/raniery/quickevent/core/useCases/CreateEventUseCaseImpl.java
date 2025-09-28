package dev.raniery.quickevent.core.useCases;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.entity.Event;

public class CreateEventUseCaseImpl implements CreateEventUseCase {

    private final EventAdapter eventAdapter;

    public CreateEventUseCaseImpl(EventAdapter eventAdapter) {
        this.eventAdapter = eventAdapter;
    }

    @Override
    public Event execute(Event event) {
        return eventAdapter.createEvent(event);
    }
}
