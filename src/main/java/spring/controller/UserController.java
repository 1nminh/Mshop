/**
 * 
 */
package spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import spring.exception.ResourceNotFoundException;
import spring.model.User;
import spring.service.UserServiceImpl;

/**
 * @author Le Ngo Minh <br/>
 *
 *         Modified Date : Apr 25, 2019
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl userService;

	@GetMapping()
//	@ResponseBody
	public List<User> listUsers() {

		List<User> userList = new ArrayList<User>();
		userList = userService.getUsers();

		return userList;
	}

	@GetMapping("/getUser")
	public User getUser(@RequestParam("userId") int theId) throws ResourceNotFoundException {

		User user = new User();
		user = userService.getUser(theId);

		return user;
	}

	@PostMapping("/saveUser")
	@ResponseStatus(value = HttpStatus.OK)
	public void saveUser(@ModelAttribute("user") User theUser) {
		userService.saveUser(theUser);
	}

	@PutMapping("/update/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void showFormForUpdate(@RequestBody User user, @PathVariable int id) throws ResourceNotFoundException {
		User theUser = new User();
		userService.getUser(id);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteUser(@PathVariable int id) throws ResourceNotFoundException {
		userService.deleteUser(id);
	}

}
