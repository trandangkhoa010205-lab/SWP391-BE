package com.fpt.dangkhoa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;
    private String brand;
    private String type;
    private String material;
    private String description;

    @OneToMany(mappedBy = "product")
    private List<ProductVariant> variants;
}
