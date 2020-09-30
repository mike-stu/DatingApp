package com.mike.course.app.mapper;

import com.mike.course.app.match.Match;
import com.mike.course.app.match.MatchDto;

public class MatchMapper {

    public static Match from(MatchDto matchDto) {
        return Match.builder()
                .fromUserId(matchDto.getFromUserId())
                .toUserId(matchDto.getToUserId())
                .likeRate(matchDto.getLikeRate())
                .build();
    }

    public static MatchDto from(Match match) {
        return MatchDto.builder()
                .fromUserId(match.getFromUserId())
                .toUserId(match.getToUserId())
                .likeRate(match.getLikeRate())
                .build();
    }
}
