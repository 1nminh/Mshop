package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.exception.ResourceNotFoundException;
import spring.model.Role;
import spring.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}

	@Transactional
	public void saveRole(Role theRole) {
		roleRepository.save(theRole);
	}

	@Transactional
	public Role getRole(int id) throws ResourceNotFoundException {
		return roleRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public void deleteRole(int theId) {
		roleRepository.deleteById(theId);
	}
    
}
