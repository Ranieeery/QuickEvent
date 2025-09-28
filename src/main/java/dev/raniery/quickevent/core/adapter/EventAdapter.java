package dev.raniery.quickevent.core.adapter;

import dev.raniery.quickevent.core.entity.Event;

import java.util.List;

public interface EventAdapter {

    Event createEvent(Event event);

    List<Event> getAllEvents();
}
