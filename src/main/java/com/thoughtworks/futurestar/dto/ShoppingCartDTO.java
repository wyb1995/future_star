package com.thoughtworks.futurestar.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {
    private String id;
    private String user_id;
}
