package com.mike.course.app.user;

import com.mike.course.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long getUserIdByEmail(String email) {
        return userRepository.getUserByEmail(email).getId();
    }

    public UserDto getUserByEmail(String email) {
        return UserMapper.from(userRepository.getUserByEmail(email));
    }

    public UserDto getUserById(Long id) {
        return UserMapper.from(userRepository.getUserById(id));
    }

    public UserDto updateUser(UserDto userDto) {
        return Optional.ofNullable(userDto)
                .map(UserMapper::from)
                .map(user -> userRepository.save(user))
                .map(UserMapper::from)
                .orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
