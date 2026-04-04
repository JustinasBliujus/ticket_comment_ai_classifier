package com.pulse.desk.tickets.controllers;

import com.pulse.desk.tickets.domain.dto.TicketDto;
import com.pulse.desk.tickets.domain.dto.TicketSummaryDto;
import com.pulse.desk.tickets.mappers.TicketMapper;
import com.pulse.desk.tickets.services.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path="/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    public TicketController(TicketService ticketService, TicketMapper ticketMapper) {
        this.ticketService = ticketService;
        this.ticketMapper = ticketMapper;
    }

    @GetMapping
    public Page<TicketSummaryDto> getTickets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ticketService.getTickets(PageRequest.of(page, size))
                .map(ticketMapper::toSummaryDto);
    }

    @GetMapping(path = "/{ticketId}")
    public TicketDto getTicket(@PathVariable("ticketId") UUID ticketId){
        return ticketMapper.toDto(ticketService.getTicketById(ticketId));
    }
}
