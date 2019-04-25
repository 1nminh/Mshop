package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.model.Role;

/**
 * @author Le Ngo Minh <br/>
 *
 * Modified Date : Apr 25, 2019
 */

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
