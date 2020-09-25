package com.mike.course.app.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MessageDto {

    private Long fromUserId;

    private Long toUserId;

    private String messageContent;
}
