package dev.raniery.quickevent.core.useCases;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.entity.Event;

public class CreateEventCaseImpl implements CreateEventCase {

    public CreateEventCaseImpl(EventAdapter eventAdapter) {
    }

    @Override
    public Event execute(Event event) {
        return null;
    }
}
