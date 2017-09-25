package com.thoughtworks.futurestar.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private String id;

    private String name;
    private String price;
}
