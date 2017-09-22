package com.thoughtworks.future_star.api;

class UserData {
    private String username;
    private String password;
    private Integer age;

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    Integer getAge() {
        return age;
    }

    void setAge(Integer age) {
        this.age = age;
    }
}
