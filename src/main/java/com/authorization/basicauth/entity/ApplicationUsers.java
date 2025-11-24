package com.authorization.basicauth.entity;

import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Table(name = "application_users")
public class ApplicationUsers implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition ="BIGSERIAL")
    private Long userId;

    @Column(unique = true)
    private String userName;
    private String userEncryptedPassword;
    @Column(unique = true)
    private String mailId;
    private String phoneNumber;
    private Timestamp createdAt;
    private Timestamp lastLogin;
    private String userRole;

    public ApplicationUsers(Long userId, String userName, String userEncryptedPassword, String mailId, String phoneNumber, Timestamp createdAt, Timestamp lastLogin, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userEncryptedPassword = userEncryptedPassword;
        this.mailId = mailId;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.userRole = userRole;
    }

    public ApplicationUsers() {
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEncryptedPassword() {
        return userEncryptedPassword;
    }

    public String getMailId() {
        return mailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEncryptedPassword(String userEncryptedPassword) {
        this.userEncryptedPassword = userEncryptedPassword;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "ApplicationUsers{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEncryptedPassword='" + userEncryptedPassword + '\'' +
                ", mailId='" + mailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdAt=" + createdAt +
                ", lastLogin=" + lastLogin +
                ", userRole='" + userRole + '\'' +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.getUserEncryptedPassword();
    }

    @Override
    public String getUsername() {
        return this.getUserName();
    }
}
