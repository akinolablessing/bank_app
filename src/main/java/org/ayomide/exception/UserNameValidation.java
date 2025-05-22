package org.ayomide.exception;

public class UserNameValidation extends RuntimeException {
  public UserNameValidation(String message) {
    super(message);
  }
}
