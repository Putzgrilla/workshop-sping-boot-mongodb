package com.Arthur.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.Arthur.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	@Query("{ 'title': { $regex:?0 /pattern/, $options: 'i' } }")
	List<Post> find(String text);
	List<Post> findByTitleContaining(String text);

}
