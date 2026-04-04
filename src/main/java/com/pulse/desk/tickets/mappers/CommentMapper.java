package com.pulse.desk.tickets.mappers;

import com.pulse.desk.tickets.domain.dto.CommentDto;
import com.pulse.desk.tickets.domain.entities.CommentEntity;

public interface CommentMapper {
    CommentEntity fromDto(CommentDto dto);
    CommentDto toDto(CommentEntity dto);
}
