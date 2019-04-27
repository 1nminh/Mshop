package spring.service;

import java.util.List;

import spring.exception.ResourceNotFoundException;
import spring.model.User;

public interface UserService {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId) throws ResourceNotFoundException;

	public void deleteUser(int theId) throws ResourceNotFoundException;

}
