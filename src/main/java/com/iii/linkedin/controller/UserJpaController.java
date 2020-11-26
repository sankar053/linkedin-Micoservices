package com.iii.linkedin.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iii.linkedin.dao.UserDaoService;
import com.iii.linkedin.model.User;
import com.iii.linkedin.model.UserNotFoundException;
import com.iii.linkedin.repo.UserRepository;



@RestController
@RequestMapping("/Udumy/users/jpa")
public class UserJpaController {

	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> retriveAllUsers() {
		return userRepository.findAll();

	}

	@GetMapping("{id}")
	public EntityModel<User> retriveUsersById(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id-" + id);
		
		EntityModel<User> resource = new EntityModel<User>(user.get());
		WebMvcLinkBuilder reportLink = linkTo(methodOn(this.getClass()).retriveAllUsers());
		resource.add(reportLink.withRel("all-users"));
		return (resource);

	}

	@PostMapping
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);

		URI currentReqUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(currentReqUri).build();
	}

	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable int id) {

		userRepository.deleteById(id);

		/*
		 * if (null == deletedUser) throw new UserNotFoundException("id-" + id);
		 */


	}

}
