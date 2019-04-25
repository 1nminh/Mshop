/**
 * 
 */
package spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.exception.ResourceNotFoundException;
import spring.model.User;
import spring.service.UserService;

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
	private UserService userService;

	@GetMapping("/list")
	public List<User> listUsers() {
//		List<User> theUsers = userService.getUsers();
//		theModel.addAttribute("users", theUsers);				
		
		return userService.getUsers();
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show user-form handler method");
		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "user-form";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {
		userService.saveUser(theUser);
		return "redirect:/user/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel)
			throws ResourceNotFoundException {
		User theUser = userService.getUser(theId);
		theModel.addAttribute("user", theUser);
		return "user-form";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId) throws ResourceNotFoundException {
		userService.deleteUser(theId);
		return "redirect:/user/list";
	}

}
