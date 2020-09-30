package com.mike.course.app.browse;

import com.mike.course.app.mapper.MatchMapper;
import com.mike.course.app.mapper.UserMapper;
import com.mike.course.app.match.MatchDto;
import com.mike.course.app.match.MatchRepository;
import com.mike.course.app.user.UserDto;
import com.mike.course.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowseService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MatchRepository matchRepository;

    public List<UserDto> getAllUsers(AreaFilterDto areaFilterDto) {
        return UserMapper.from(
                userRepository.getAllUsers(
                        areaFilterDto.getId(),
                        areaFilterDto.getCountry(),
                        areaFilterDto.getState(),
                        areaFilterDto.getCity(),
                        areaFilterDto.getGender()
                ));
    }

    public void gradeUser(MatchDto matchDto) {
        matchRepository.save(MatchMapper.from(matchDto));
    }
}
