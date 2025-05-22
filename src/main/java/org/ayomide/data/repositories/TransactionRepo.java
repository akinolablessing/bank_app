package org.ayomide.data.repositories;

import org.ayomide.Main;
import org.ayomide.data.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepo extends MongoRepository<Transaction,String> {
}
