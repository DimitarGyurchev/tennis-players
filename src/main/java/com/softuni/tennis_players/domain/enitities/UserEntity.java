package com.softuni.tennis_players.domain.enitities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private List<UserRoleEntity> roles;

    @OneToMany(mappedBy = "createdBy")
    private List<TennisPlayerEntity> tennisPlayers;

    public List<TennisPlayerEntity> getTennisPlayers() {
        return tennisPlayers;
    }

    public UserEntity setTennisPlayers(List<TennisPlayerEntity> tennisPlayers) {
        this.tennisPlayers = tennisPlayers;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}
