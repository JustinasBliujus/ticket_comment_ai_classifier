package com.pulse.desk.tickets.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CommentDto(
        UUID id,
        TicketDto ticket,
        String comment,
        LocalDateTime created
) {}
