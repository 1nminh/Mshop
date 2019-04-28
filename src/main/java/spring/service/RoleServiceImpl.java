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
	private RoleRepository repository;

	@Transactional
	@Override
	public List<Role> all() {
		return repository.findAll();
	}

	@Transactional
	@Override
	public Role newRole(Role newRole) {
		return repository.save(newRole);
	}

	@Transactional
	@Override
	public Role one(int id) throws ResourceNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	@Override
	public Role replaceRole(Role newRole, int id) {
		return repository.findById(id)
			      .map(role -> {
			        role.setRoleName(newRole.getRoleName());
			        return repository.save(role);
			      })
			      .orElseGet(() -> {
			        newRole.setRoleId(id);
			        return repository.save(newRole);
			      });
	}

	@Transactional
	@Override
	public void deleteRole(int id) {
		repository.deleteById(id);
	}

//	@Transactional
//	@Override
//	public List<Role> all() {
//		return roleRepository.findAll();
//	}
//
//	@Transactional
//	@Override
//	public void saveRole(Role theRole) {
//		roleRepository.save(theRole);
//	}
//
//	@Transactional
//	@Override
//	public Role getRole(int id) throws ResourceNotFoundException {
//		return roleRepository.findById(id).orElseThrow(
//				() -> new ResourceNotFoundException(id));
//	}
//
//	@Transactional
//	@Override
//	public void deleteRole(int theId) {
//		roleRepository.deleteById(theId);
//	}

}
