package com.pulse.desk.tickets.domain.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChoiceDto(
        @JsonProperty("message") MessageDto message,
        @JsonProperty("finish_reason") String finishReason
) {}