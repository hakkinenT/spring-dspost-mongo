package com.hakkinenT.dspost.repositories;

import com.hakkinenT.dspost.models.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
