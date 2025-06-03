package org.ayomide.data.model;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.DataOutput;
import java.time.LocalDateTime;


@Getter
@Setter
public class Transaction {
    @Id
    private String transactionId;

    private String accountNumber;
    private double balance;
    private double amount;
    private String fromAccount;
    private String toAccount;
    private TransactionType transactionType;
    private AccountType accountType;
    private String description;
    private LocalDateTime transactionDate;

//   @ManyToOne
//    private Account account;

}
