package neoris.crud.stripe.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import neoris.crud.stripe.model.User;
import neoris.crud.stripe.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository repositorio;
	
	@Override
	public ResponseEntity<User> createUser(User User) {
		try {
			
			return new ResponseEntity<User> (repositorio.save(User), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<User> (HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public List<User> fetchUsers() {
		return repositorio.findAll();
	}
	
	@Override
	public ResponseEntity<User> fetchUser(Long id) {
		try {
			
			User user = repositorio.findById(id).orElseThrow();
			return new ResponseEntity<User> (user, HttpStatus.FOUND);
			
		} catch (NoSuchElementException noSuchElement) {
			return new ResponseEntity<User> (HttpStatus.NOT_FOUND);
		} catch (IllegalArgumentException illegalArgument) {
			return new ResponseEntity<User> (HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public ResponseEntity<User> editUser(Long id, User user) {
		try {

			User foundUser = repositorio.findById(id).orElseThrow();
			if (user.getName() != null)
				foundUser.setName(user.getName());
			if (user.getSurname() != null)
				foundUser.setSurname(user.getSurname());
			if (user.getPhone() != 0)
				foundUser.setPhone(user.getPhone());
			
			repositorio.save(foundUser);
			return new ResponseEntity<User> (foundUser, HttpStatus.FOUND);
			
		} catch (NoSuchElementException noSuchElement) {
			
			return new ResponseEntity<User> (HttpStatus.NOT_FOUND);
			
		} catch (IllegalArgumentException illegalArgument) {
			
			return new ResponseEntity<User> (HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<User> deleteUser(Long id) {
		
		try {
			
			User user = repositorio.findById(id).orElseThrow();
			repositorio.deleteById(id);
			return new ResponseEntity<User> (user, HttpStatus.OK);
			
		} catch (NoSuchElementException noSuchElement) {
			
			return new ResponseEntity<User> (HttpStatus.NOT_FOUND);
			
		} catch (IllegalArgumentException illegalArgument) {
			
			return new ResponseEntity<User> (HttpStatus.BAD_REQUEST);
		}
		
	}
}
