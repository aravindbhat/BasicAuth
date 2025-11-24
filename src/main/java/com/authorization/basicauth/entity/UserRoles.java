package com.authorization.basicauth.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;

@Entity
public class UserRoles {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer roleId;
    private String roleName;
    private Integer roleLevel;
    private Timestamp createdAt;
    private Timestamp lastModified;

    public UserRoles() {
    }

    public UserRoles(Integer roleID, String roleName, Integer roleLevel, Timestamp createdAt, Timestamp lastModified) {
        this.roleId = roleID;
        this.roleName = roleName;
        this.roleLevel = roleLevel;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public Integer getRoleLevel() {
        return roleLevel;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setRoleId(Integer roleID) {
        this.roleId = roleID;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "roleID=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleLevel='" + roleLevel + '\'' +
                ", createdAt=" + createdAt +
                ", lastModified=" + lastModified +
                '}';
    }
}
