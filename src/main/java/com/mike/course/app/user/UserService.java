package com.mike.course.app.user;

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
        User user = userRepository.findUserByEmail(email);

        // todo Need to use mapping method to transfer between UserDto and User
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findUserById(id);

        // todo Need to use mapping method to transfer between UserDto and User
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());
        userDto.setCountry(user.getAddress().getCountry());
        userDto.setState(user.getAddress().getState());
        userDto.setCity(user.getAddress().getCity());
        userDto.setGender(user.getGender());
        userDto.setDateOfBirth(user.getDateOfBirth());

        return userDto;
    }

    public UserDto updateUser(UserDto userDto) {
        // todo Need to validate UserDto before object transfer

        // todo Need to use mapping method to transfer between UserDto and User
        User user = new User();
        user.setId(userDto.getId());
        user.setPassword("pw");
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setAddress(new Address(userDto.getCountry(), userDto.getState(), userDto.getCity()));
        user.setGender(userDto.getGender());
        user.setDateOfBirth(userDto.getDateOfBirth());

        User updatedUser = userRepository.save(user);

        UserDto updatedUserDto = new UserDto();
        updatedUserDto.setId(updatedUser.getId());
        updatedUserDto.setName(updatedUser.getName());
        updatedUserDto.setSurname(updatedUser.getSurname());
        updatedUserDto.setEmail(updatedUser.getEmail());
        updatedUserDto.setCountry(updatedUser.getAddress().getCountry());
        updatedUserDto.setState(updatedUser.getAddress().getState());
        updatedUserDto.setCity(updatedUser.getAddress().getCity());
        updatedUserDto.setGender(updatedUser.getGender());
        updatedUserDto.setDateOfBirth(updatedUser.getDateOfBirth());

        return updatedUserDto;
    }

    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setAddress(new Address(userDto.getCountry(), userDto.getState(), userDto.getCity()));
        user.setGender(userDto.getGender());
        user.setDateOfBirth(userDto.getDateOfBirth());

        User updatedUser = userRepository.save(user);

        UserDto updatedUserDto = new UserDto();
        updatedUserDto.setId(updatedUser.getId());
        updatedUserDto.setName(updatedUser.getName());
        updatedUserDto.setSurname(updatedUser.getSurname());
        updatedUserDto.setEmail(updatedUser.getEmail());
        updatedUserDto.setCountry(updatedUser.getAddress().getCountry());
        updatedUserDto.setState(updatedUser.getAddress().getState());
        updatedUserDto.setCity(updatedUser.getAddress().getCity());
        updatedUserDto.setGender(updatedUser.getGender());
        updatedUserDto.setDateOfBirth(updatedUser.getDateOfBirth());

        return updatedUserDto;
    }
}
