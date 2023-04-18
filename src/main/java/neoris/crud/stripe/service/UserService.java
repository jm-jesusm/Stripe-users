package neoris.crud.stripe.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import neoris.crud.stripe.model.User;

public interface UserService {
	//POST
	public ResponseEntity<User> createUser(User user);
	
	//GET
	public List<User> fetchUsers();
	
	//GET
	public ResponseEntity<User> fetchUser(Long id);
	
	//PUT
	public ResponseEntity<User> editUser(Long id, User user);
	
	//DELETE
	public ResponseEntity<User> deleteUser(Long id);
}
