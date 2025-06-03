package org.ayomide.services;

import lombok.AllArgsConstructor;
import org.ayomide.data.model.Account;
import org.ayomide.data.model.Customer;
import org.ayomide.data.repositories.AccountRepository;
import org.ayomide.dto.request.AccountRequest;
import org.ayomide.dto.response.AccountResponse;
import org.ayomide.exception.AccountNumberValidation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountService implements AccountServiceInter {

    private final AccountRepository accountRepository;


    @Override
    public AccountResponse createBankAccount(AccountRequest request) {
        AccountResponse response = new AccountResponse();

        Random random = new Random();
        long number = 1_000_000_000L + (Math.abs(random.nextLong()) % 9_000_000_000L);
        String accountNumber = String.valueOf(number);
        if (accountNumber.startsWith("ACCT-")) {
            accountNumber = accountNumber.substring(1);
        }
        Account account = new Account();
        account.setAccountNumber(accountNumber);

        account.setBalance(0.0);
        account.setUserName(request.getUserName());
        account.setCreatedAt(LocalDateTime.now());
        accountRepository.save(account);

        response.setAccountNumber(accountNumber);
        response.setUserName(request.getUserName());
        response.setBalance(0.0);
        response.setMessage("Bank Account Created Successful");
        return response;
    }

    @Override
    public AccountResponse getAccountByNumber(AccountRequest accountNumber) {

        Optional<Account> optionalAccount = accountRepository.findByAccountNumber(accountNumber.getAccountNumber());
        String stringAccountNumber = accountNumber.getAccountNumber();
        if(optionalAccount.isEmpty()){
           throw new AccountNumberValidation("Account not found with number: "+stringAccountNumber);
        }
        Account account = optionalAccount.get();

        AccountResponse response = new AccountResponse();
        response.setAccountNumber(account.getAccountNumber());
        response.setUserName(account.getUserName());
        response.setBalance(account.getBalance());
        response.setMessage("Account retrieved successfully");

        return response;
    }

    @Override
    public List<Account> getAccountByUser(String userId) {
        return List.of();
    }
}
