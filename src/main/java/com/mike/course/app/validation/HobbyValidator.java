package com.mike.course.app.validation;

import com.mike.course.app.constant.HobbyValidatorConstant;
import com.mike.course.app.exception.InvalidHobbyException;
import com.mike.course.app.hobby.HobbyDto;
import com.mike.course.app.hobby.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HobbyValidator {

    @Autowired
    HobbyService hobbyService;

    public void validateAddHobby(HobbyDto hobbyDto) throws InvalidHobbyException {
        if (hobbyService.getHobby(hobbyDto) != null) {
            throw new InvalidHobbyException(HttpStatus.BAD_REQUEST, HobbyValidatorConstant.HOBBY_ALREADY_EXIST);
        }
    }
}
