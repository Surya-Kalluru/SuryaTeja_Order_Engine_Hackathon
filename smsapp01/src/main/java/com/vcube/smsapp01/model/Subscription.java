package com.vcube.smsapp01.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "subscriptions")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Subscription {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double amount;
    private LocalDate startDate;
    private LocalDate nextRenewalDate;

    @Enumerated(EnumType.STRING)
    private RenewalType renewalType;

    @Enumerated(EnumType.STRING)
    private Stat stat;

    private boolean autoRenew;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
