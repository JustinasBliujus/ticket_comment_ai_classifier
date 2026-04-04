package com.pulse.desk.tickets.repositories;

import com.pulse.desk.tickets.domain.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, UUID> {
    Optional<TicketEntity> findByCommentId(UUID commentId);
}
