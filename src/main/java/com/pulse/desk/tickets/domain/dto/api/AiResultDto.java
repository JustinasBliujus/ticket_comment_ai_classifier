package com.pulse.desk.tickets.domain.dto.api;

import com.pulse.desk.tickets.domain.entities.TicketCategory;
import com.pulse.desk.tickets.domain.entities.TicketPriority;

public record AiResultDto(
        boolean createTicket,
        String title,
        TicketCategory category,
        TicketPriority priority,
        String summary
) {}
