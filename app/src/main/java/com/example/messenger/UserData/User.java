package com.example.messenger.UserData;

public class User {
    public String userId;
    public String fullName;
    public String phone;
    public String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String userId, String fullName, String phone, String email) {
        this.userId = userId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }
}
