package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.User;
import com.spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService registrationService;

	@GetMapping(value="/get",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		return registrationService.getAllUsers();
	}

	@PostMapping(value="/register", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User registerUser(@RequestBody User user) {
		return registrationService.save(user);
	}

	@GetMapping(value="/details",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User getDetails(@RequestHeader(name="auth-token") String auth) {
			return registrationService.getDetails(auth);
	}
	
	@PostMapping(value="/login",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public String login(@RequestBody User user){
		return registrationService.login(user);
	}
	
	@DeleteMapping(value="/logout",produces=MediaType.APPLICATION_JSON_VALUE)
	public User logoutUser(@RequestHeader(name="auth-token") String auth) {
		return registrationService.logout(auth);
	}
	
	@PutMapping(value="/update/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User updateUser(@RequestBody User user, @PathVariable(value="id") String id) {
		return registrationService.update(user, id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public boolean deleteUser(@PathVariable(value="id") String id) {
		return registrationService.delete(id);
	}
	
}
