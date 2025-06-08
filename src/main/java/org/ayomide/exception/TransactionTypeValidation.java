package org.ayomide.exception;

public class TransactionTypeValidation extends RuntimeException {
    public TransactionTypeValidation(String message) {
        super(message);
    }
}
