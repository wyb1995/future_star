package com.thoughtworks.futurestar.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Builder
public class AddressDTO {
//    private String id;
    private String address;
}
