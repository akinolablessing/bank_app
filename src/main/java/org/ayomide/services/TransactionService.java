package org.ayomide.services;

import lombok.AllArgsConstructor;
import org.ayomide.data.model.*;
import org.ayomide.data.repositories.AccountRepository;
import org.ayomide.data.repositories.TransactionRepo;
import org.ayomide.dto.request.TransactionRequest;
import org.ayomide.dto.response.BalanceResponse;
import org.ayomide.dto.response.TransactionResponse;
import org.ayomide.exception.AccountNumberValidation;
import org.ayomide.exception.AmountTranferException;
import org.ayomide.exception.AmountWithdrawException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.ayomide.validation.Validation.*;

@Service
@AllArgsConstructor
public class TransactionService implements TransactionServiceInter{

    private final TransactionRepo transactionRepo;

    private final AccountRepository accountRepository;

    @Override

    public TransactionResponse deposit(TransactionRequest request) {
        if (request.getAmount() <= 0) {
            throw new AmountTranferException("Deposit amount must be positive");
        }


        Account account = accountRepository.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new AccountNumberValidation("Account not found with number: " + request.getAccountNumber()));


        double newBalance = account.getBalance() + request.getAmount();
        account.setBalance(newBalance);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccountNumber(account.getAccountNumber());
        transaction.setAmount(request.getAmount());
        transaction.setBalance(newBalance);
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setAccountType(AccountType.SAVINGS);
        transaction.setDescription(request.getDescription());
        transaction.setTransactionDate(LocalDateTime.now());
        transactionRepo.save(transaction);


        TransactionResponse response = new TransactionResponse();
        response.setStatus(Status.SUCCESS);
        response.setAmount(request.getAmount());
        response.setTransactionType(TransactionType.DEPOSIT);
        response.setUpdatedBalance(newBalance);
        response.setMessage("Deposit successful");

        return response;
    }


    @Override
    public TransactionResponse withdraw(TransactionRequest request) {
        if(request.getAmount() <= 0){
            throw new AmountTranferException("Withdraw amount must be positive");
        }
        Account account = accountRepository.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new AccountNumberValidation("Account not found with number: " + request.getAccountNumber()));

        if(account.getBalance() < request.getAmount()){
            throw new AmountWithdrawException("Insufficient balance for withdraw..");
        }

        double newBalance = account.getBalance() - request.getAmount();
        account.setBalance(newBalance);
        accountRepository.save(account);

        Transaction withdrawTransaction = new Transaction();
        withdrawTransaction.setAccountNumber(account.getAccountNumber());
        withdrawTransaction.setAmount(request.getAmount());
        withdrawTransaction.setBalance(newBalance);
        withdrawTransaction.setTransactionType(TransactionType.WITHDRAWAL);
        withdrawTransaction.setAccountType(AccountType.SAVINGS);
        withdrawTransaction.setDescription(request.getDescription());
        withdrawTransaction.setTransactionDate(LocalDateTime.now());
        transactionRepo.save(withdrawTransaction);

        TransactionResponse response = new TransactionResponse();
        response.setStatus(Status.SUCCESS);
        response.setAmount(request.getAmount());
        response.setTransactionType(TransactionType.WITHDRAWAL);
        response.setUpdatedBalance(newBalance);
        response.setMessage("Withdrawal successful");

        return response;

    }

    @Override
    public TransactionResponse transfer(TransactionRequest request) {
        if (request.getAmount() <= 0) {
            throw new AmountTranferException("Transfer amount must be positive");
        }

        if (request.getFromAccount().equals(request.getToAccount())) {
            throw new IllegalArgumentException("Source and destination accounts cannot be the same");
        }

        Account fromAccount = accountRepository.findByAccountNumber(request.getFromAccount())
                .orElseThrow(() -> new AccountNumberValidation("Sender account not found: " + request.getFromAccount()));

        if (fromAccount.getBalance() < request.getAmount()) {
            throw new AmountTranferException("Insufficient balance for transfer");
        }

        Account toAccount = accountRepository.findByAccountNumber(request.getToAccount())
                .orElseThrow(() -> new AccountNumberValidation("Receiver account not found: " + request.getToAccount()));

        fromAccount.setBalance(fromAccount.getBalance() - request.getAmount());
        toAccount.setBalance(toAccount.getBalance() + request.getAmount());

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        LocalDateTime now = LocalDateTime.now();

        Transaction debitTransaction = new Transaction();
        debitTransaction.setAccountNumber(fromAccount.getAccountNumber());
        debitTransaction.setAmount(request.getAmount());
        debitTransaction.setBalance(fromAccount.getBalance());
        debitTransaction.setTransactionType(TransactionType.TRANSFER);
        debitTransaction.setDescription("Transfer to " + toAccount.getAccountNumber());
        debitTransaction.setTransactionDate(now);
        transactionRepo.save(debitTransaction);

        Transaction creditTransaction = new Transaction();
        creditTransaction.setAccountNumber(toAccount.getAccountNumber());
        creditTransaction.setAmount(request.getAmount());
        creditTransaction.setBalance(toAccount.getBalance());
        creditTransaction.setTransactionType(TransactionType.TRANSFER);
        creditTransaction.setAccountType(AccountType.SAVINGS);
        creditTransaction.setDescription("Transfer from " + fromAccount.getAccountNumber());
        creditTransaction.setTransactionDate(now);
        transactionRepo.save(creditTransaction);

        TransactionResponse response = new TransactionResponse();
        response.setStatus(Status.SUCCESS);
        response.setAmount(request.getAmount());
        response.setTransactionType(TransactionType.TRANSFER);
        response.setUpdatedBalance(fromAccount.getBalance());
        response.setMessage("Transfer successful from " + fromAccount.getAccountNumber() + " to " + toAccount.getAccountNumber());

        return response;
    }

    @Override
    public BalanceResponse checkBalance(TransactionRequest request) {
        BalanceResponse response = new BalanceResponse();
        if (request == null || request.getAccountNumber() == null || request.getAccountNumber().isEmpty()) {
            throw new IllegalArgumentException("Account number must be provided");
        }

        Account account = accountRepository.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new AccountNumberValidation("Account not found: " + request.getAccountNumber()));
       response.setAccountNumber(account.getAccountNumber());
       response.setBalance(account.getBalance());
        return response;
    }

}
