package org.ayomide.exception;

public class AccountNumberValidation extends RuntimeException {
    public AccountNumberValidation(String message) {
        super(message);
    }
}
