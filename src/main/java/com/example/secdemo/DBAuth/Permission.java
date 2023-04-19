package com.example.secdemo.DBAuth;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;
    private String permission;

    public Permission() {
    }

    public Permission(Long permissionId, String permission) {
        this.permissionId = permissionId;
        this.permission = permission;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
