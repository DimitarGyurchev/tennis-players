package com.softuni.tennis_players.domain.dtos.view;

public class CommentViewDTO {

    private Long id;
    private String coachName;
    private String message;

    public CommentViewDTO() {
    }

    public CommentViewDTO(Long id, String coachName, String message) {
        this.id = id;
        this.coachName = coachName;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public CommentViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCoachName() {
        return coachName;
    }

    public CommentViewDTO setCoachName(String coachName) {
        this.coachName = coachName;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommentViewDTO setMessage(String message) {
        this.message = message;
        return this;
    }
}
