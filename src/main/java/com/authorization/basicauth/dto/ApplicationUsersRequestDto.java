package com.authorization.basicauth.dto;

import lombok.Data;

@Data
public class ApplicationUsersRequestDto {
    private String userName;
    private String password;
    private String mailId;
    private String phoneNumber;

    public ApplicationUsersRequestDto(String userName, String password, String mailId, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.mailId = mailId;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMailId() {
        return mailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ApplicationUsersRequestDto{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mailId='" + mailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
