package dev.raniery.quickevent.core.useCases;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.entity.Event;

public class GetEventByTicketCodeUseCaseImpl implements GetEventByTicketCodeUseCase {

    private final EventAdapter eventAdapter;

    public GetEventByTicketCodeUseCaseImpl(EventAdapter eventAdapter) {
        this.eventAdapter = eventAdapter;
    }

    @Override
    public Event execute(String ticketCode) {
        return eventAdapter.getEventByTicketCode(ticketCode);
    }
}
