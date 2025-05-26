package org.ayomide.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.ayomide.data.model.Status;
import org.ayomide.data.model.TransactionType;

@Getter
@Setter
public class TransactionResponse {
    private Status status;
    private TransactionType transactionType;
    private double amount;
    private double updatedBalance;
    private String message;

}
