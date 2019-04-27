package spring.service;

import java.util.List;

import spring.exception.ResourceNotFoundException;
import spring.model.Role;

public interface RoleService {

	public List<Role> getRoles();

	public void saveRole(Role theRole);

	public Role getRole(int theId) throws ResourceNotFoundException;

	public void deleteRole(int theId) throws ResourceNotFoundException;

}
