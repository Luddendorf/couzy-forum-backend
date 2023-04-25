
package com.example.repository;
import com.example.dao.User;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	User save(User user);
	Optional<User> findById(Long id);
}