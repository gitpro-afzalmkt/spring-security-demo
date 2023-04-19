package com.example.secdemo.DBAuth;

import javax.persistence.*;

@Entity
@Table(name = "role_perm")
public class RolePermissionMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "permissionId")
    private Permission permission;

    public RolePermissionMapping(Long id, Role role, Permission permission) {
        this.id = id;
        this.role = role;
        this.permission = permission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
