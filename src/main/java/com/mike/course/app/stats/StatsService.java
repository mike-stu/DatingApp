package com.mike.course.app.stats;

import com.mike.course.app.hobby.HobbyAmountDto;
import com.mike.course.app.mapper.UserMapper;
import com.mike.course.app.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StatsService {

    @Autowired
    StatsRepository statsRepository;

    public Map<String, Long> getGenderProportion() {
        return Stream
                .of(new Object[][] {
                        {"Male", statsRepository.countByGender("Male")},
                        {"Female", statsRepository.countByGender("Female")}})
                .collect(Collectors.toMap(data -> (String) data[0], data -> (Long) data[1]));
    }

    public List<UserDto> getUsersWithGreatestLikes() {
        return UserMapper.from(statsRepository.getTop10OrderByLikes());
    }

    public Map<String, Long> getUsersByCountry() {
        return statsRepository
                .getUsersByCountry()
                .stream()
                .collect(Collectors.toMap(data -> (String) data[1], data -> (Long) data[0]));
    }

    List<HobbyAmountDto> getUsersByHobby() {
        return statsRepository
                .getUsersByHobby()
                .stream()
                .map(data -> HobbyAmountDto
                        .builder()
                        .name((String) data[1])
                        .amount((Long) data[0])
                        .build())
                .collect(Collectors.toList());
    }
}
