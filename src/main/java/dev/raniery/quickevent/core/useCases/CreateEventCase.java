package dev.raniery.quickevent.core.useCases;

import dev.raniery.quickevent.core.entity.Event;

public interface CreateEventCase {

    Event execute(Event event);
}
