package com.example.digitalstore.DTO;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private String product_id;

    private String product_name;


    private int product_price;


    private String product_info;
}
