package org.ayomide.services;

import org.ayomide.dto.request.TransactionRequest;
import org.ayomide.dto.response.BalanceResponse;
import org.ayomide.dto.response.TransactionResponse;

public interface TransactionServiceInter {
    TransactionResponse deposit(TransactionRequest request);
    TransactionResponse withdraw(TransactionRequest request);
    TransactionResponse transfer(TransactionRequest request);
    BalanceResponse checkBalance(TransactionRequest request);
}
