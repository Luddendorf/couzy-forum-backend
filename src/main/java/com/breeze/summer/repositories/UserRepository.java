package com.breeze.summer.repositories;

import com.breeze.summer.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<CouzyUser, Long> { // Since it is a generic, we are passing the
                                                                          // type (User) and the ID type (which is long)
    // We are just providing the interface, Spring will provide us with the
    // implementation

    // if we want some special operations which are not there in CrudRepository,
    // then we can include it here

    Optional<User> findByUsername(String username);

    Optional<User> findByUsername(String username);
}
