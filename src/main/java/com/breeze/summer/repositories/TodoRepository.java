package com.breeze.summer.repositories;

import com.breeze.summer.models.Todo;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {        // Since it is a generic, we are passing the type (Todo) and the ID type (which is long)
    // We are just providing the interface, Spring will provide us with the implementation

    // if we want some special operations which are not there in CrudRepository, then we can include it here

    public List<Todo> findByAuthorId(Long user_id);
}
