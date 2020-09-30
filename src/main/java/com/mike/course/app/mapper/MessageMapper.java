package com.mike.course.app.mapper;

import com.mike.course.app.message.Message;
import com.mike.course.app.message.MessageDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MessageMapper {

    public static Message from(MessageDto messageDto) {
        return Message.builder()
                .messageContent(messageDto.getMessageContent())
                .fromUserId(messageDto.getFromUserId())
                .toUserId(messageDto.getFromUserId())
                .dateSentTime(LocalDateTime.now())
                .build();
    }

    public static MessageDto from(Message message) {
        return MessageDto.builder()
                .messageContent(message.getMessageContent())
                .fromUserId(message.getFromUserId())
                .toUserId(message.getFromUserId())
                .build();
    }

    public static List<MessageDto> from(List<Message> messageList) {
        return messageList.stream()
                .map(MessageMapper::from)
                .collect(Collectors.toList());
    }
}
