package edu.aspire.boot.user;

import java.net.URI;
import java.util.List;

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
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import edu.aspire.boot.exception.UserNotFoundException;

@RestController
public class UserDaoResource	 
{
	@Autowired
	private UserDaoService service;
	 
	
	//gives list of users
	@GetMapping(path="/users")
	public List<User> retreiveAllUsers()
	{
		return service.findAll();
	}
	
	
	@GetMapping(path="/users/{id}")
	public User   retrieveUser(@PathVariable int id)
	{
		User user=service.findOne(id);
		
		if(user==null) throw new UserNotFoundException("id-"+ id);
		
		
		return user;
		
		

		
	}

	
	


	@PostMapping(path="/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user)
	{
		User savedUser = service.save(user);
		
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/deleteusers/{id}")
	public void delete(@PathVariable int id)
	{
	User user=service.deleteById(id);
	
	
	if(user==null)
		throw new UserNotFoundException("id" +id);
	}
}
