package com.mike.course.app.match;

import com.mike.course.app.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @GetMapping
    public List<UserDto> getAllUsers(@RequestParam(value = "email") String email) {
        return matchService.getMatches(email);
    }
}
