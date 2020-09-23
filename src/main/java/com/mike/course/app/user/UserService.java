package com.mike.course.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long getUserIdByEmail(String email) {
        return userRepository.getUserByEmail(email).getId();
    }

    public UserDto getUserByEmail(String email) {
        User user = userRepository.getUserByEmail(email);

        // todo Need to use mapping method to transfer between UserDto and User
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());
        // ...

        return userDto;
    }

    public UserDto updateUser(UserDto userDto) {
        // todo Need to validate UserDto before object transfer

        // todo Need to use mapping method to transfer between UserDto and User
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());

        User updatedUser = userRepository.save(user);

        UserDto updatedUserDto = new UserDto();
        updatedUserDto.setId(updatedUser.getId());
        updatedUserDto.setName(updatedUser.getName());
        updatedUserDto.setSurname(updatedUser.getSurname());
        updatedUserDto.setEmail(updatedUser.getEmail());

        return updatedUserDto;
    }
}
