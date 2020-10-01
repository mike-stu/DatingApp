package com.mike.course.app.mapper;

import com.mike.course.app.user.Address;
import com.mike.course.app.user.User;
import com.mike.course.app.user.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User from(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .address(Address.builder()
                        .country(userDto.getCountry())
                        .state(userDto.getState())
                        .city(userDto.getCity())
                        .build()
                )
                .gender(userDto.getGender())
                .dateOfBirth(userDto.getDateOfBirth())
                .build();
    }

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .country(user.getAddress().getCountry())
                .state(user.getAddress().getState())
                .city(user.getAddress().getCity())
                .gender(user.getGender())
                .dateOfBirth(user.getDateOfBirth())
                .build();
    }

    public static List<UserDto> from(List<User> userList) {
        return userList.stream()
                .map(UserMapper::from)
                .collect(Collectors.toList());
    }
}
