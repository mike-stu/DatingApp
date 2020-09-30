package com.mike.course.app.browse;

import com.mike.course.app.match.MatchDto;
import com.mike.course.app.user.UserDto;
import com.mike.course.app.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/browse")
public class BrowseController {

    @Autowired
    BrowseService browseService;

    @Autowired
    UserService userService;

    @GetMapping(path = "/all")
    public List<UserDto> getAllUsers(AreaFilterDto areaFilterDto) {
        return browseService.getAllUsers(areaFilterDto);
    }

    @PostMapping(path = "/grade")
    public void likeUser(@RequestBody MatchDto matchDto) {
        browseService.gradeUser(matchDto);
    }

    @GetMapping(path = "/id")
    public Long getId(@RequestHeader(value = "email") String email) {
        return userService.getUserIdByEmail(email);
    }
}
