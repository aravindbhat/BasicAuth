package com.authorization.basicauth.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ApplicationUsersResponseDto {
    private String userName;
    private String token;
    private Timestamp issuedAt;
    private Timestamp expireAt;

    public ApplicationUsersResponseDto() {
    }

    public ApplicationUsersResponseDto(String userName, String token, Timestamp issuedAt, Timestamp expireAt) {
        this.userName = userName;
        this.token = token;
        this.issuedAt = issuedAt;
        this.expireAt = expireAt;
    }

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }

    public Timestamp getIssuedAt() {
        return issuedAt;
    }

    public Timestamp getExpireAt() {
        return expireAt;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setIssuedAt(Timestamp issuedAt) {
        this.issuedAt = issuedAt;
    }

    public void setExpireAt(Timestamp expireAt) {
        this.expireAt = expireAt;
    }

    @Override
    public String toString() {
        return "ApplicationUsersResponseDto{" +
                "userName='" + userName + '\'' +
                ", token='" + token + '\'' +
                ", issuedAt='" + issuedAt + '\'' +
                ", expireAt='" + expireAt + '\'' +
                '}';
    }
}
