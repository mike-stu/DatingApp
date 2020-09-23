package com.mike.course.app.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User getUserByEmail(String email);

}
