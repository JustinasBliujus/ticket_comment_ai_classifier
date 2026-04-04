package com.pulse.desk.tickets.services.impl;

import com.pulse.desk.tickets.domain.dto.api.AiResultDto;
import com.pulse.desk.tickets.domain.entities.CommentEntity;
import com.pulse.desk.tickets.domain.entities.TicketEntity;
import com.pulse.desk.tickets.repositories.CommentRepository;
import com.pulse.desk.tickets.repositories.TicketRepository;
import com.pulse.desk.tickets.services.AiService;
import com.pulse.desk.tickets.services.CommentService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final AiService aiService;
    private final TicketRepository ticketRepository;

    public CommentServiceImpl(CommentRepository commentRepository, AiService aiService, TicketRepository ticketRepository) {
        this.commentRepository = commentRepository;
        this.aiService = aiService;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Page<CommentEntity> getComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public CommentEntity createComment(CommentEntity comment) {

        CommentEntity savedComment = commentRepository.save(comment);
        log.info("Comment saved with ID: {}", savedComment.getId());

        AiResultDto aiResult = aiService.analyze(comment.getComment());
        log.info("AI result: isTicket={}", aiResult.createTicket());

        if (aiResult.createTicket()) {
            TicketEntity ticket = new TicketEntity(
                    null,
                    savedComment,
                    aiResult.title(),
                    aiResult.category(),
                    aiResult.priority(),
                    aiResult.summary(),
                    null,
                    null
            );
            TicketEntity savedTicket = ticketRepository.save(ticket);
            savedComment.setTicket(ticket);
            log.info("Ticket saved with ID: {}", savedTicket.getId());
        } else {
            log.info("AI decided this is NOT a ticket");
        }
        return savedComment;
    }
}
