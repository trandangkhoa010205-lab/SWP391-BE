package com.fpt.dangkhoa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prescriptions")
@Data
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;

    private BigDecimal sphereLeft;
    private BigDecimal sphereRight;
    private BigDecimal cylinderLeft;
    private BigDecimal cylinderRight;
    private BigDecimal axisLeft;
    private BigDecimal axisRight;

    private String note;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
