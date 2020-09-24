package com.mike.course.app.match;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getAllByFromUserId(Long fromUserId);
}
