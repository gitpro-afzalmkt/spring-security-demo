package com.example.secdemo.DBAuth;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column(nullable = false)
    private String role;

    public Role() {
    }

    public Role(Long roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
