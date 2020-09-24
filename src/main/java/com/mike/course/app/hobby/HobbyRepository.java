package com.mike.course.app.hobby;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HobbyRepository extends CrudRepository<Hobby, Long> {

    List<Hobby> getAllByUserId(Long userId);
}
