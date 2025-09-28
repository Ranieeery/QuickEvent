package dev.raniery.quickevent.infra.config;

import dev.raniery.quickevent.core.adapter.EventAdapter;
import dev.raniery.quickevent.core.useCases.CreateEventCase;
import dev.raniery.quickevent.core.useCases.CreateEventCaseImpl;
import dev.raniery.quickevent.core.useCases.GetAllEventsCase;
import dev.raniery.quickevent.core.useCases.GetAllEventsCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventCase createEventCase(EventAdapter eventAdapter) {
        return new CreateEventCaseImpl(eventAdapter);
    }

    @Bean
    public GetAllEventsCase getAllEventsCase(EventAdapter eventAdapter) {
        return new GetAllEventsCaseImpl(eventAdapter);
    }
}
