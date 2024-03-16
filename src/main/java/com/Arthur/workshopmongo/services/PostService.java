package com.Arthur.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arthur.workshopmongo.domain.Post;
import com.Arthur.workshopmongo.repository.PostRepository;
import com.Arthur.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;

	public Post findById(String id) {

		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));

	}
	public List<Post> findByTitle(String text){
		return repo.findByTitleContaining(text);
	}
}
