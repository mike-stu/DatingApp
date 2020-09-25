package com.mike.course.app.mapper;

import com.mike.course.app.hobby.Hobby;
import com.mike.course.app.hobby.HobbyDto;

import java.util.List;
import java.util.stream.Collectors;

public class HobbyMapper {

    public static Hobby from(HobbyDto hobbyDto) {
        return Hobby.builder()
                .id(hobbyDto.getId())
                .userId(hobbyDto.getUserId())
                .name(hobbyDto.getName())
                .build();
    }

    public static HobbyDto from(Hobby hobby) {
        return HobbyDto.builder()
                .id(hobby.getId())
                .userId(hobby.getUserId())
                .name(hobby.getName())
                .build();
    }

    public static List<HobbyDto> from(List<Hobby> hobbyList) {
        return hobbyList
                .stream()
                .map(HobbyMapper::from)
                .collect(Collectors.toList());
    }
}
