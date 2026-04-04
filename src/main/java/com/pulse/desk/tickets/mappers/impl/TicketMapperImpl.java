package com.pulse.desk.tickets.mappers.impl;

import com.pulse.desk.tickets.domain.dto.TicketDto;
import com.pulse.desk.tickets.domain.dto.TicketSummaryDto;
import com.pulse.desk.tickets.domain.entities.TicketEntity;
import com.pulse.desk.tickets.mappers.TicketMapper;
import org.springframework.stereotype.Component;

@Component
public class TicketMapperImpl implements TicketMapper {

    @Override
    public TicketDto toDto(TicketEntity ticket) {
        return new TicketDto(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getCategory(),
                ticket.getPriority(),
                ticket.getSummary(),
                ticket.getCreated(),
                ticket.getUpdated()
        );
    }

    @Override
    public TicketSummaryDto toSummaryDto(TicketEntity ticket) {
        return new TicketSummaryDto(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getCategory(),
                ticket.getPriority()
        );
    }
}