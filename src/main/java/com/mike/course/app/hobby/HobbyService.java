package com.mike.course.app.hobby;

import com.mike.course.app.mapper.HobbyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {

    @Autowired
    HobbyRepository hobbyRepository;

    public void addHobby(HobbyDto hobbyDto) {
        hobbyRepository.save(HobbyMapper.from(hobbyDto));
    }

    public List<HobbyDto> getAllHobby(Long userId) {
        return HobbyMapper.from(hobbyRepository.getAllByUserId(userId));
    }

    public void deleteHobby(HobbyDto hobbyDto) {
        hobbyRepository.delete(HobbyMapper.from(hobbyDto));
    }
}
