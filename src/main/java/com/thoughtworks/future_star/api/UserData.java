package com.thoughtworks.future_star.api;

public class UserData {
    private String username;
    private String password;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
