package com.mike.course.app.hobby;

import com.mike.course.app.exception.InvalidHobbyException;
import com.mike.course.app.mapper.HobbyMapper;
import com.mike.course.app.validation.HobbyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {

    @Autowired
    HobbyRepository hobbyRepository;
    @Autowired
    HobbyValidator hobbyValidator;

    public void addHobby(HobbyDto hobbyDto) throws InvalidHobbyException {
        hobbyValidator.validateAddHobby(hobbyDto);
        hobbyRepository.save(HobbyMapper.from(hobbyDto));
    }

    public List<HobbyDto> getAllHobby(Long userId) {
        return HobbyMapper.from(hobbyRepository.getAllByUserId(userId));
    }

    public void deleteHobby(HobbyDto hobbyDto) {
        hobbyRepository.delete(HobbyMapper.from(hobbyDto));
    }

    public HobbyDto getHobby(HobbyDto hobbyDto) {
        return HobbyMapper.from(hobbyRepository.getByUserIdAndName(hobbyDto.getUserId(), hobbyDto.getName()));
    }
}
