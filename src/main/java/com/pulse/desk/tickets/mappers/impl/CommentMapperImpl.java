package com.pulse.desk.tickets.mappers.impl;

import com.pulse.desk.tickets.domain.dto.CommentDto;
import com.pulse.desk.tickets.domain.entities.CommentEntity;
import com.pulse.desk.tickets.mappers.CommentMapper;
import com.pulse.desk.tickets.mappers.TicketMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommentMapperImpl implements CommentMapper {

    private final TicketMapper ticketMapper;

    public CommentMapperImpl(TicketMapper ticketMapper) {
        this.ticketMapper = ticketMapper;
    }

    @Override
    public CommentEntity fromDto(CommentDto dto) {
        return new CommentEntity(
                dto.id(),
                null,
                dto.comment(),
                dto.created()
        );
    }

    @Override
    public CommentDto toDto(CommentEntity entity) {
        return new CommentDto(
                entity.getId(),
                Optional.ofNullable(entity.getTicket())
                        .map(ticketMapper::toDto)
                        .orElse(null),
                entity.getComment(),
                entity.getCreated()
        );
    }
}