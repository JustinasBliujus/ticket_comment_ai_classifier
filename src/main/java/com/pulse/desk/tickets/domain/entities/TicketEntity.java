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
@Table(name="tickets")
@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    @Column(name="id",updatable=false,nullable=false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="comment_id", updatable=false, nullable=false)
    private CommentEntity comment;

    @Column(name="title",nullable=false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name="category",nullable=false)
    private TicketCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name="priority",nullable=false)
    private TicketPriority priority;

    @Column(name="summary",nullable=false)
    private String summary;

    @Column(name="created",nullable = false,updatable=false)
    private LocalDateTime created;

    @Column(name="updated",nullable = false)
    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }
}
