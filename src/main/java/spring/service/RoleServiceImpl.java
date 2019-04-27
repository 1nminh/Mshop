package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.exception.ResourceNotFoundException;
import spring.model.Role;
import spring.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	@Override
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}

	@Transactional
	@Override
	public void saveRole(Role theRole) {
		roleRepository.save(theRole);
	}

	@Transactional
	@Override
	public Role getRole(int id) throws ResourceNotFoundException {
		return roleRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Transactional
	@Override
	public void deleteRole(int theId) {
		roleRepository.deleteById(theId);
	}
    
}
