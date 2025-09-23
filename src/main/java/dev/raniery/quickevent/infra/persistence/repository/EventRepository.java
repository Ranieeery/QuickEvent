package dev.raniery.quickevent.infra.persistence.repository;

import dev.raniery.quickevent.infra.persistence.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
