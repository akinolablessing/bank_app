package org.ayomide.data.repositories;

import org.ayomide.data.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account,String> {
    Optional<Account> findByAccountNumber(String accountNumber);

}
