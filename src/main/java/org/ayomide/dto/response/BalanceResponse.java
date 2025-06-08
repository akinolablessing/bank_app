package org.ayomide.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceResponse {
    private String accountNumber;
    private double balance;
}
