package dev.raniery.quickevent.infra.persistence.repository;

import dev.raniery.quickevent.infra.persistence.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
    boolean existsByTicketCode(String ticketCode);

    Optional<EventEntity> findByTicketCode(String ticketCode);

    List<EventEntity> findAllByNameContaining(String name);
}
