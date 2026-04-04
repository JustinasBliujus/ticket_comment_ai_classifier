package com.pulse.desk.tickets.services;

import com.pulse.desk.tickets.domain.entities.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<CommentEntity> getComments(Pageable page);
    CommentEntity createComment(CommentEntity comment);
}
