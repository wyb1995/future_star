package com.thoughtworks.future_star.dto;

public class UserConfigDTO {
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

    @Override
    public String toString() {
        return "{ username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age + " }";
    }
}
