package com.pulse.desk.tickets.domain.dto;

public record ErrorResponse(
        int status,
        String message
) {}
