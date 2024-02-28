package com.Arthur.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Arthur.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
