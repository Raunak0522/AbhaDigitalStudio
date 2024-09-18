package com.example.digitalstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Product")
public class Product {

    @Id
    @Column(name="Product_id")
    private String product_id;

    @Column(name="Product_name")
    private String product_name;

    @Column(name="Product_price")
    private int product_price;

    @Column(name="Product_info")
    private String product_info;

}
