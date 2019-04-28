package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.exception.ResourceNotFoundException;
import spring.model.User;
import spring.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/all")
	public List<User> all() {
		return service.all();
	}

	@PostMapping("/add")
	public User newUser(@RequestBody User newUser) {
		return service.newUser(newUser);
	}

	@GetMapping("get/{id}")
	public User one(@PathVariable("id") int id) throws ResourceNotFoundException {
			return service.one(id);
	}
	
	@PutMapping("/put/{id}")
	public User replaceUser(@RequestBody User newUser, @PathVariable("id") int id) {
	    return service.replaceUser(newUser, id);
	  }
	
	 @DeleteMapping("/delete/{id}")
	  void deleteUser(@PathVariable int id) {
	    service.deleteUser(id);
	  }
}