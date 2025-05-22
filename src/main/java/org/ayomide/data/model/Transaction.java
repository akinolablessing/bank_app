package org.ayomide.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
public class Transaction {
    @Id
    private String transactionId;
    private String accountNumber;
    private double amount;
    private TransactionType transactionType;
    private String transactionDate;
    private String status;

}
