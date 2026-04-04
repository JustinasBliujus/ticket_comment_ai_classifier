package com.pulse.desk.tickets.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="comments")
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id",nullable=false,updatable=false)
    private UUID id;

    @OneToOne(mappedBy = "comment", cascade = {CascadeType.REMOVE})
    private TicketEntity ticket;

    @Column(name="comment",nullable=false, updatable=false)
    private String comment;

    @Column(name="created",nullable = false,updatable=false)
    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
    }
}
