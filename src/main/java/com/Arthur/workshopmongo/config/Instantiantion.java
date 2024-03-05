package com.Arthur.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Arthur.workshopmongo.domain.Post;
import com.Arthur.workshopmongo.domain.User;
import com.Arthur.workshopmongo.dto.AuthorDTO;
import com.Arthur.workshopmongo.repository.PostRepository;
import com.Arthur.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiantion implements CommandLineRunner {
	@Autowired
	UserRepository userrepo;
	@Autowired
	PostRepository postRepo;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userrepo.deleteAll();
		postRepo.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userrepo.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/10/2003"), "patos", "vi um pato", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/10/2003"), "patos", "vi dois pato", new AuthorDTO(maria));

		postRepo.saveAll(Arrays.asList(post1, post2));
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userrepo.save(maria);
	}

}
