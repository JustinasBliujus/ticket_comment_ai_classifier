package com.pulse.desk.tickets.domain.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageDto(
        @JsonProperty("role") String role,
        @JsonProperty("content") String content){}
