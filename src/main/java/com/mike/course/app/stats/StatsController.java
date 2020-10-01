package com.mike.course.app.stats;

import com.mike.course.app.hobby.HobbyAmountDto;
import com.mike.course.app.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    StatsService statsService;

    @GetMapping(path = "/gender")
    public Map<String, Long> getGenderProportion() {
        return statsService.getGenderProportion();
    }

    @GetMapping(path = "/like")
    public List<UserDto> getUsersWithGreatestLikes() {
        return statsService.getUsersWithGreatestLikes();
    }

    @GetMapping(path = "/userByCountry")
    public Map<String, Long> getUsersByCountry() {
        return statsService.getUsersByCountry();
    }

    @GetMapping(path = "/userByHobby")
    public List<HobbyAmountDto> getUsersByHobby() {
        return statsService.getUsersByHobby();
    }
}
