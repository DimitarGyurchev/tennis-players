package com.softuni.tennis_players.domain.dtos.binding;

public class CommentCreationDTO {
    private String username;
    private Long playerId;
    private String message;

    public CommentCreationDTO(String username, Long playerId, String message) {
        this.username = username;
        this.playerId = playerId;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public CommentCreationDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public CommentCreationDTO setPlayerId(Long playerId) {
        this.playerId = playerId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommentCreationDTO setMessage(String message) {
        this.message = message;
        return this;
    }
}
