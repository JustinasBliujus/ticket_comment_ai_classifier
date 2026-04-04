package com.pulse.desk.tickets.mappers;

import com.pulse.desk.tickets.domain.dto.TicketDto;
import com.pulse.desk.tickets.domain.dto.TicketSummaryDto;
import com.pulse.desk.tickets.domain.entities.TicketEntity;

public interface TicketMapper {
    TicketDto toDto(TicketEntity ticket);
    TicketSummaryDto toSummaryDto(TicketEntity ticket);
}
