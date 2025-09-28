package dev.raniery.quickevent.core.useCases;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.entity.Event;

import java.util.List;

public class GetEventByNameUseCaseImpl implements GetEventByNameUseCase {

    private final EventAdapter eventAdapter;

    public GetEventByNameUseCaseImpl(EventAdapter eventAdapter) {
        this.eventAdapter = eventAdapter;
    }

    @Override
    public List<Event> execute(String name) {
        return eventAdapter.getEventByName(name);
    }
}
