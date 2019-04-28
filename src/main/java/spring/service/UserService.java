package spring.service;

import java.util.List;

import spring.exception.ResourceNotFoundException;
import spring.model.User;

public interface UserService {

	List<User> all();

	User newUser(User newUser);

	User one(int id) throws ResourceNotFoundException;

	User replaceUser(User newUser, int id);

	void deleteUser(int id);

}
