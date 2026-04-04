package com.pulse.desk.tickets.domain.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AiRequestDto(
        @JsonProperty List<MessageDto> messages,
        @JsonProperty String model,
        @JsonProperty boolean stream,
        @JsonProperty("max_tokens") int maxTokens
) {}