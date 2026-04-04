package com.pulse.desk.tickets.services.impl;

import com.pulse.desk.tickets.domain.entities.TicketEntity;
import com.pulse.desk.tickets.repositories.TicketRepository;
import com.pulse.desk.tickets.services.TicketService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Page<TicketEntity> getTickets(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }

    @Override
    public TicketEntity getTicketById(UUID id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found: " + id));
    }
}