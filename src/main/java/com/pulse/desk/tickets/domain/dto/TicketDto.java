package com.pulse.desk.tickets.domain.dto;

import com.pulse.desk.tickets.domain.entities.TicketCategory;
import com.pulse.desk.tickets.domain.entities.TicketPriority;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketDto(
    UUID id,
    String title,
    TicketCategory category,
    TicketPriority priority,
    String summary,
    LocalDateTime created,
    LocalDateTime updated
) {}
