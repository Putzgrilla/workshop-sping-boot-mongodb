package com.Arthur.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Arthur.workshopmongo.domain.Post;
import com.Arthur.workshopmongo.domain.User;
import com.Arthur.workshopmongo.dto.UserDTO;
import com.Arthur.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findall() {
		List<User> list = service.findall();
		List<UserDTO> listdtoDto = list.stream().map(p-> new UserDTO(p)).collect( Collectors.toList());
		return ResponseEntity.ok().body(listdtoDto);

	}
	@GetMapping(value = "{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(obj));

	}
	
	@PostMapping
	public ResponseEntity<Void> Insert(@RequestBody UserDTO obj) {
		User obj1 =service.fromDTO(obj);
		obj1 =service.insert(obj1);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj1.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delte(@PathVariable String id) {
	 service.delete(id);
		
		return ResponseEntity.noContent().build();

	}
	@PutMapping(value = "{id}")
	public ResponseEntity<Void> Upadte(@RequestBody UserDTO obj,@PathVariable String id) {
		User obj1 =service.fromDTO(obj);
		obj1.setId(id);
		obj1 =service.update(obj1);
		return ResponseEntity.noContent().build();

	}
	@GetMapping(value = "{id}/posts")
	public ResponseEntity<List<Post>> findpost(@PathVariable String id) {
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj.getPosts());
		}
}
