package edu.aspire.boot.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.aspire.boot.exception.UserNotFoundException;


@RestController
public class UserJPAResource {

	

	@Autowired
	private UserDaoService service;
	
	@Autowired
	private UserRepository userRepository;
	 
	
	//gives list of users
	@GetMapping(path="/jpa/users")
	public List<User> retreiveAllUsers()
	{
		return userRepository.findAll();
	}
	
	
	@GetMapping(path="/jpa/users/{id}")
	public Optional<User>   retrieveUser(@PathVariable int id)
	{
		Optional<User> user=userRepository.findById(id);
		
		
		
		if(!user.isPresent()) 
			throw new UserNotFoundException("id-"+ id);
		
		
		return user;
		
		

		
	}

	
	


	@PostMapping(path="/jpa/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user)
	{
		User savedUser = userRepository.save(user);
		
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/jpa/deleteusers/{id}")
	public void delete(@PathVariable int id)
	{
	userRepository.deleteById(id);
	
	
	
	}
}


