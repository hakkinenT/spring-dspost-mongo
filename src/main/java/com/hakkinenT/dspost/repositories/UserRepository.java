package com.hakkinenT.dspost.repositories;

import com.hakkinenT.dspost.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
