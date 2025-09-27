package dev.raniery.quickevent.core.useCases;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.entity.Event;

public class CreateEventCaseImpl implements CreateEventCase {

    private final EventAdapter eventAdapter;

    public CreateEventCaseImpl(EventAdapter eventAdapter) {
        this.eventAdapter = eventAdapter;
    }

    @Override
    public Event execute(Event event) {
        return eventAdapter.createEvent(event);
    }
}
