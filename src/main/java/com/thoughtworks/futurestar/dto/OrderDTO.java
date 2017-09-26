package com.thoughtworks.futurestar.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OrderDTO {
    private String address;
    private List<String> itemIds;
}
