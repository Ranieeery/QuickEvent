package dev.raniery.quickevent.infra.config;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.useCases.CreateEventUseCase;
import dev.raniery.quickevent.core.useCases.CreateEventUseCaseImpl;
import dev.raniery.quickevent.core.useCases.GetAllEventsUseCase;
import dev.raniery.quickevent.core.useCases.GetAllEventsUseCaseImpl;
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
}
