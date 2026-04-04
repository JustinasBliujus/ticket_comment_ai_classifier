package com.pulse.desk.tickets.domain.dto;

import com.pulse.desk.tickets.domain.entities.TicketCategory;
import com.pulse.desk.tickets.domain.entities.TicketPriority;

import java.util.UUID;

public record TicketSummaryDto(
        UUID id,
        String title,
        TicketCategory category,
        TicketPriority priority
) {}