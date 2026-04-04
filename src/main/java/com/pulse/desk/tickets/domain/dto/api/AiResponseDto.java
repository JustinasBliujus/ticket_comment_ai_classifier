package com.pulse.desk.tickets.domain.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record AiResponseDto(
        @JsonProperty("choices") List<ChoiceDto> choices
) {}