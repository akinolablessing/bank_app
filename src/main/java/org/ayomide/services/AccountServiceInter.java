package org.ayomide.services;

import org.ayomide.data.model.Account;
import org.ayomide.data.model.Customer;
import org.ayomide.dto.request.AccountRequest;
import org.ayomide.dto.response.AccountResponse;

import java.util.List;

public  interface AccountServiceInter {
AccountResponse createBankAccount(AccountRequest request);
AccountResponse getAccountByNumber(AccountRequest request);
List<Account> getAccountByUser(String userId);

}
