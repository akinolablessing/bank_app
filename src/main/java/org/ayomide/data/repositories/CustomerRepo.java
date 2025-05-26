package org.ayomide.data.repositories;

import org.ayomide.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,String> {
    Customer findByUserGmail (String userGmail);
}
