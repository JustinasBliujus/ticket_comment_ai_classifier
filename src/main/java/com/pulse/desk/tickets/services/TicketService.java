package com.pulse.desk.tickets.services;

import com.pulse.desk.tickets.domain.entities.TicketEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TicketService {
    Page<TicketEntity> getTickets(Pageable page);
    TicketEntity getTicketById(UUID id);
}