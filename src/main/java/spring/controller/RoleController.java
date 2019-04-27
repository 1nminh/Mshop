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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import spring.exception.ResourceNotFoundException;
import spring.model.Role;
import spring.service.RoleServiceImpl;

/**
 * @author Le Ngo Minh <br/>
 *
 *         Modified Date : Apr 25, 2019
 */

@RestController
@RequestMapping("/api/role")
public class RoleController {

	private static final Logger LOG = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleServiceImpl roleService;

	@GetMapping()
//	@ResponseBody
	public List<Role> listRoles() {

		List<Role> roleList = new ArrayList<Role>();
		roleList = roleService.getRoles();

		return roleList;
	}

	@GetMapping("/getRole")
	public Role getRole(@RequestParam("roleId") int theId) throws ResourceNotFoundException {

		Role role = new Role();
		role = roleService.getRole(theId);

		return role;
	}

	@PostMapping("/saveRole")
	@ResponseStatus(value = HttpStatus.OK)
	public void saveRole(@ModelAttribute("role") Role theRole) {
		roleService.saveRole(theRole);
	}

	@GetMapping("/updateRole")
	@ResponseStatus(value = HttpStatus.OK)
	public void showFormForUpdate(@RequestParam("roleId") int theId, Model theModel) throws ResourceNotFoundException {
		Role theRole = new Role();
		roleService.getRole(theId);
	}

	@GetMapping("/delete")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteRole(@RequestParam("roleId") int theId) throws ResourceNotFoundException {
		roleService.deleteRole(theId);
	}

}
