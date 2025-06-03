package org.ayomide.data.repositories;

import org.ayomide.data.model.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankAccountRepo extends MongoRepository<BankAccount,String> {

}
