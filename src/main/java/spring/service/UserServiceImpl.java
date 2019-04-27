package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.exception.ResourceNotFoundException;
import spring.model.User;
import spring.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Transactional
	@Override
	public void saveUser(User theUser) {
		userRepository.save(theUser);
	}

	@Transactional
	@Override
	public User getUser(int id) throws ResourceNotFoundException {
		return userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Transactional
	@Override
	public void deleteUser(int theId) {
		userRepository.deleteById(theId);
	}
    
}
