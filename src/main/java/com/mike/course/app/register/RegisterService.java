package com.mike.course.app.register;

import com.mike.course.app.exception.InvalidUserException;
import com.mike.course.app.user.UserDto;
import com.mike.course.app.user.UserService;
import com.mike.course.app.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    UserService userService;
    @Autowired
    UserValidator userValidator;

    public UserDto registerUser(UserDto userDto) throws InvalidUserException {
        userValidator.validateRegisterUser(userDto);
        return userService.createUser(userDto);
    }
}
