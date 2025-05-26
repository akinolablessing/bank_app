package org.ayomide.data.model;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Getter
@Setter
public class Transaction {
    @Id
    private String transactionId;

    private String accountNumber;
    private double amount;
    private TransactionType transactionType;
    private String description;
    private LocalDateTime transactionDate;

   @ManyToOne
    private Account account;

}
