package com.Arthur.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Arthur.workshopmongo.domain.Post;
import com.Arthur.workshopmongo.resources.util.URL;
import com.Arthur.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	@Autowired
	private PostService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);

		return ResponseEntity.ok().body(obj);

	}

	@GetMapping(value = "/titleseach")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParan(text);
		List<Post> obj = service.findByTitle(text);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/fullseach")
	public ResponseEntity<List<Post>> findForAll(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minDate", defaultValue = "") String minText,
			@RequestParam(value = "maxDate", defaultValue = "") String maxText) {
		text = URL.decodeParan(text);
		Date min = URL.dateConvert(minText, new Date(0L));
		Date max = URL.dateConvert(maxText, new Date());
		List<Post> List = service.findForAll(text, min, max);

		return ResponseEntity.ok().body(List);
	}

}
