package dev.raniery.quickevent.infra.persistence.repository;

import dev.raniery.quickevent.infra.persistence.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//TODO: existsByTicketCode to check for unique ticket codes
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    boolean existsByTicketCode(String ticketCode);

    Optional<EventEntity> findByTicketCode(String ticketCode);
}
