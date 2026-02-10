package com.fpt.dangkhoa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "staffs")
@Data
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    private String name;
    private String email;
    private String phone;
    private String role;
    private String password;

    @OneToMany(mappedBy = "staff")
    private List<Order> orders;
}

