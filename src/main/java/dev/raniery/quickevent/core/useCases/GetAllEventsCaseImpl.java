package dev.raniery.quickevent.core.useCases;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.entity.Event;

import java.util.List;

public class GetAllEventsCaseImpl implements GetAllEventsCase {

    private final EventAdapter eventAdapter;

    public GetAllEventsCaseImpl(EventAdapter eventAdapter) {
        this.eventAdapter = eventAdapter;
    }

    @Override
    public List<Event> execute() {
        return eventAdapter.getAllEvents();
    }
}
