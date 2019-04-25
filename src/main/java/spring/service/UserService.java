package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.exception.ResourceNotFoundException;
import spring.model.User;
import spring.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Transactional
	public void saveUser(User theUser) {
		userRepository.save(theUser);
	}

	@Transactional
	public User getUser(int id) throws ResourceNotFoundException {
		return userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public void deleteUser(int theId) {
		userRepository.deleteById(theId);
	}
    
}
