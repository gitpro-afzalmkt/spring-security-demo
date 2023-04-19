package com.example.secdemo.DBAuth;

import javax.annotation.Nonnull;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    @Column(unique = true, nullable = false)
    private String password;
    @Column(columnDefinition = "boolean default true")
    private boolean isEnabled;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId")
    private Role role;

    public User() {
    }

    public User(String username, String password, boolean isEnabled, Role role) {
        this.username = username;
        this.password = password;
        this.isEnabled = isEnabled;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
