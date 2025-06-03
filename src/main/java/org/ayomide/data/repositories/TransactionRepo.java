package org.ayomide.data.repositories;

import org.ayomide.Main;
import org.ayomide.data.model.Account;
import org.ayomide.data.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TransactionRepo extends MongoRepository<Transaction,String> {
    Optional<Transaction> findByAccountNumber(String accountNumber);

}
