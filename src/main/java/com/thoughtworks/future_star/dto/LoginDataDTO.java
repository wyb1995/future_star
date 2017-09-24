package com.thoughtworks.future_star.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginDataDTO {
    private String username;
    private String password;
}
