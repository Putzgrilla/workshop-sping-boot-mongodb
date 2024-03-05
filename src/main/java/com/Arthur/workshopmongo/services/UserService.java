package com.Arthur.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arthur.workshopmongo.domain.User;
import com.Arthur.workshopmongo.dto.UserDTO;
import com.Arthur.workshopmongo.repository.UserRepository;
import com.Arthur.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public List<User> findall() {
		return repo.findAll();
	}

	public User findById(String id) {

		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));

	}
	public User insert(User obj) {
		return repo.insert(obj);
		
		
	}
	public User update(User obj) {
		User objNew = findById(obj.getId());
		updateData(objNew,obj);
		return repo.save(objNew);
	}
	public void updateData(User objNew, User obj) {
		objNew.setName(obj.getName());
		objNew.setEmail(obj.getEmail());
	}
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(),obj.getName(),obj.getEmail());
		
	}
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
}
