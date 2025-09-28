package dev.raniery.quickevent.core.adapter;

import dev.raniery.quickevent.core.entity.Event;

import java.util.List;

public interface EventAdapter {

    Event createEvent(Event event);

    List<Event> getAllEvents();

    boolean existsByTicketCode(String ticketCode);

    Event getEventById(Long id);

    Event getEventByTicketCode(String ticketCode);

    List<Event> getEventByName(String name);
}
