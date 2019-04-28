package spring.service;

import java.util.List;

import spring.exception.ResourceNotFoundException;
import spring.model.Role;

public interface RoleService {

	List<Role> all();

	Role newRole(Role newRole);

	Role one(int id) throws ResourceNotFoundException;

	Role replaceRole(Role newRole, int id);

	void deleteRole(int id);
}
