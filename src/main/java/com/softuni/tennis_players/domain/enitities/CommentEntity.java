package com.softuni.tennis_players.domain.enitities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {
    @Column
    private boolean approved;
    @Column
    private LocalDateTime created;
    @Column(nullable = false)
    private String text;

    @ManyToOne
    private UserEntity author;
    @ManyToOne
    private TennisPlayerEntity tennisPlayer;

    public CommentEntity() {
    }

    public boolean isApproved() {
        return approved;
    }

    public CommentEntity setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public CommentEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getText() {
        return text;
    }

    public CommentEntity setText(String text) {
        this.text = text;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public CommentEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public TennisPlayerEntity getTennisPlayer() {
        return tennisPlayer;
    }

    public CommentEntity setTennisPlayer(TennisPlayerEntity tennisPlayer) {
        this.tennisPlayer = tennisPlayer;
        return this;
    }
}
