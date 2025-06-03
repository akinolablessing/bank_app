package org.ayomide.data.repositories;

import org.ayomide.dto.request.OtpRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepo extends MongoRepository<OtpRequest,String> {
}
