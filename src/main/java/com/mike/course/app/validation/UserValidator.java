package com.mike.course.app.validation;

import com.mike.course.app.constant.UserValidatorConstant;
import com.mike.course.app.exception.InvalidUserException;
import com.mike.course.app.user.UserDto;
import com.mike.course.app.user.UserService;
import com.mike.course.app.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserValidator {

    @Autowired
    UserService userService;

    public void validateRegisterUser(UserDto userDto) throws InvalidUserException {
        if (userService.getUserByEmail(userDto.getEmail()) != null) {
            throw new InvalidUserException(HttpStatus.BAD_REQUEST, UserValidatorConstant.USER_EMAIL_ALREADY_EXIST);
        }

        if (notBetweenYearRange(UserUtil.getUserAge(userDto),
                UserValidatorConstant.LOWER_AGE_BOUND,
                UserValidatorConstant.UPPER_AGE_BOUND)) {
            throw new InvalidUserException(HttpStatus.BAD_REQUEST, UserValidatorConstant.USER_AGE_IS_WRONG);
        }
    }

    private boolean betweenYearRange(int age, int lowerBoundInclusive, int upperBoundInclusive) {
        return age >= lowerBoundInclusive && age <= upperBoundInclusive;
    }

    private boolean notBetweenYearRange(int age, int lowerBoundInclusive, int upperBoundInclusive) {
        return !betweenYearRange(age, lowerBoundInclusive, upperBoundInclusive);
    }
}
