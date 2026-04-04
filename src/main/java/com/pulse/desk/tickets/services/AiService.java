package com.pulse.desk.tickets.services;

import com.pulse.desk.tickets.domain.dto.api.AiResultDto;

public interface AiService {
    AiResultDto analyze(String comment);
}
