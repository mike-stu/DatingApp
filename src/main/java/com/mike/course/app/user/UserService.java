package com.mike.course.app.user;

import com.mike.course.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Long getUserIdByEmail(String email) {
       return userRepository.findUserByEmail(email).getId();
    }

    public UserDto getUserByEmail(String email) {
        return UserMapper.from(userRepository.findUserByEmail(email));
    }

    public UserDto getUserById(Long id) {
        return UserMapper.from(userRepository.findUserById(id));
    }

    public UserDto updateUser(UserDto userDto) {
        return UserMapper.from(userRepository.save(UserMapper.from(userDto)));
    }

    public UserDto createUser(UserDto userDto) {
        return UserMapper.from(userRepository.save(UserMapper.from(userDto)));
    }
}
