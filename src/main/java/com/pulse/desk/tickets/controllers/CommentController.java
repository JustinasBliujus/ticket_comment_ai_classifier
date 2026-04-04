package com.pulse.desk.tickets.controllers;

import com.pulse.desk.tickets.domain.dto.CommentDto;
import com.pulse.desk.tickets.mappers.CommentMapper;
import com.pulse.desk.tickets.services.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @GetMapping
    public Page<CommentDto> getComments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return commentService.getComments(PageRequest.of(page, size))
                .map(commentMapper::toDto);
    }

    @PostMapping
    public CommentDto createComment(@RequestBody CommentDto commentDto) {
        return commentMapper.toDto(
                commentService.createComment(
                        commentMapper.fromDto(commentDto)
                )
        );
    }
}
