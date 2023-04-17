package com.softuni.tennis_players.domain.dtos.binding;

public class CreateCommentDTO {
    private Long playerId;
    private String username;
    private String message;

    public CreateCommentDTO(Long playerId, String username, String message) {
        this.playerId = playerId;
        this.username = username;
        this.message = message;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public CreateCommentDTO setPlayerId(Long playerId) {
        this.playerId = playerId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CreateCommentDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CreateCommentDTO setMessage(String message) {
        this.message = message;
        return this;
    }
}
