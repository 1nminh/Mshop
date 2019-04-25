package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.model.User;

/**
 * @author Le Ngo Minh <br/>
 *
 * Modified Date : Apr 25, 2019
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

}
