package dev.raniery.quickevent.core.useCases;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.entity.Event;

public class SearchEventCaseImpl implements SearchEventCase {

    private final EventAdapter eventAdapter;

    public SearchEventCaseImpl(EventAdapter eventAdapter) {
        this.eventAdapter = eventAdapter;
    }

    @Override
    public Event execute(String name) {
        return null;
    }
}
