package org.ayomide.data.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccount {
    private String accountNumber;
    private String balance;
    private String bankName;
    private String accountHolderName;
    private AccountType accountType;
}
