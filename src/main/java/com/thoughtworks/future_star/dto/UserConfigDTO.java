package com.thoughtworks.future_star.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class UserConfigDTO {
    private String username;
    private String password;
    private Integer age;
}
