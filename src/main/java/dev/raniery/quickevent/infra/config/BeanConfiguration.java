package dev.raniery.quickevent.infra.config;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.useCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUseCase createEventUseCase(EventAdapter eventAdapter) {
        return new CreateEventUseCaseImpl(eventAdapter);
    }

    @Bean
    public GetAllEventsUseCase getAllEventsUseCase(EventAdapter eventAdapter) {
        return new GetAllEventsUseCaseImpl(eventAdapter);
    }

    @Bean
    public GetEventByIdUseCase getEventByIdUseCase(EventAdapter eventAdapter) {
        return new GetEventByIdUseCaseImpl(eventAdapter);
    }

    @Bean
    public GetEventByTicketCodeUseCase getEventByTicketCodeUseCase(EventAdapter eventAdapter) {
        return new GetEventByTicketCodeUseCaseImpl(eventAdapter);
    }
}
