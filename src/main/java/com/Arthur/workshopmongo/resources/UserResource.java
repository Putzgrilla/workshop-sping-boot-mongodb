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
		User objt = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(objt));

	}
	@PostMapping
	public ResponseEntity<Void> Insert(@RequestBody UserDTO obj) {
		User user =service.fromDTO(obj);
		user =service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delte(@PathVariable String id) {
	 service.delete(id);
		
		return ResponseEntity.noContent().build();

	}
	@PutMapping(value = "{id}")
	public ResponseEntity<Void> Upadte(@RequestBody UserDTO obj,@PathVariable String id) {
		User user =service.fromDTO(obj);
		user.setId(id);
		user =service.update(user);
		return ResponseEntity.noContent().build();

	}
}
