package dev.raniery.quickevent.infra.service;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class TicketCodeGeneratorService {

    public String execute() {
        return "EVT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
