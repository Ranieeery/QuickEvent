package dev.raniery.quickevent.core.useCases;

import dev.raniery.quickevent.core.entity.Event;

import java.util.List;

public interface GetAllEventsCase {

    List<Event> execute();
}
