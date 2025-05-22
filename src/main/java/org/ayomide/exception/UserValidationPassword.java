package org.ayomide.exception;

public class UserValidationPassword extends RuntimeException {
    public UserValidationPassword(String message) {
        super(message);
    }
}
