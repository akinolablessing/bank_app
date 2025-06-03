package org.ayomide.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponse {
    private String accountNumber;
    private String userName;
    private double balance;
    private String message;
}
