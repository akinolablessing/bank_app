package org.ayomide.data.model;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class Account {
    @Id
    private String id;

    private  String accountNumber;
    private double balance;
    private LocalDateTime createdAt;

    @ManyToOne
    private Customer customer;
}
