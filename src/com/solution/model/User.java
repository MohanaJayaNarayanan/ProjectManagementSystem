package com.solution.model;

import com.solution.enums.UserType;

/**
 * This class contains the attributes of the resource User model
 */
public class User {

    Long userId;
    String userName;
    UserType userType;
    Double salary;
    boolean isAvailable;

    public User(Long userId, String userName, UserType userType, Double salary,boolean isAvailable) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.salary = salary;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userType=" + userType +
                ", salary=" + salary +
                '}';
    }
}
