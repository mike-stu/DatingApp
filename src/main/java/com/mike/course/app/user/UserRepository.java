package com.mike.course.app.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User getUserByEmail(String email);

    User getUserById(Long id);

    @Query("SELECT u FROM User u " +
            "WHERE u.id NOT IN (SELECT m.toUserId from Match m WHERE m.fromUserId = :userId)" +
            "AND u.id <> :userId " +
            "AND u.address.country = :country " +
            "AND u.address.state = :state " +
            "AND u.address.city = :city " +
            "AND u.gender = :gender")
    List<User> getAllUsers(Long userId, String country, String state, String city, String gender);
}
