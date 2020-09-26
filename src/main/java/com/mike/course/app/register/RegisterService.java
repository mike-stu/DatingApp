package com.mike.course.app.register;

import com.mike.course.app.user.User;
import com.mike.course.app.user.UserDto;
import com.mike.course.app.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    UserService userService;

    public UserDto registerUser(UserDto userDto) {
        return userService.createUser(userDto);
    }
}
