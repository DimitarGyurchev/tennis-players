package com.softuni.tennis_players.domain.dtos.model;

public class UserRoleModel {

    private String id;

    private String role;

    public String getId() {
        return id;
    }

    public UserRoleModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserRoleModel setRole(String role) {
        this.role = role;
        return this;
    }
}
