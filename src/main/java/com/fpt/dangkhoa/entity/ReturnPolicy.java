package com.fpt.dangkhoa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "return_policies")
@Data
public class ReturnPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;

    private String name;
    private String description;
    private Integer durationDays;
    private LocalDateTime createdAt;
}

