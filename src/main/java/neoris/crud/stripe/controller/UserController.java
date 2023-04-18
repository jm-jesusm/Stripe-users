package neoris.crud.stripe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import neoris.crud.stripe.model.User;
import neoris.crud.stripe.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
		
	@Autowired
	private UserService servicio;
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return servicio.createUser(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> fetchUsers() {
		return new ResponseEntity<List<User>> (servicio.fetchUsers(), HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> fetchUser(@PathVariable("id") Long id) {
		return servicio.fetchUser(id);
	}
	
	@PutMapping(path = "/{id}", consumes = "application/json")
	public ResponseEntity<User> editUser(@PathVariable("id") Long id, @RequestBody User User) {
		return servicio.editUser(id, User);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		return servicio.deleteUser(id);
	}
}


