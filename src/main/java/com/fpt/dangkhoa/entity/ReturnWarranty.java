package com.fpt.dangkhoa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "return_warranties")
@Data
public class ReturnWarranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warrantyId;

    private String type;
    private String reason;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private ReturnPolicy returnPolicy;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
}

