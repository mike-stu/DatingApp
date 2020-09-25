package com.mike.course.app.message;

import com.mike.course.app.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserService userService;

    @Transactional
    public void sendMessage(MessageDto messageDto) {
        Message message = new Message();
        message.setMessageContent(messageDto.getMessageContent());
        message.setFromUserId(messageDto.getFromUserId());
        message.setToUserId(messageDto.getToUserId());
        message.setDateSent(LocalDateTime.now());

        messageRepository.save(message);
    }

    List<MessageDto> getMessage(String email, Long friendId) {
        Long userId = userService.getUserIdByEmail(email);
        List<Message> messageList = messageRepository.getAllByUserIdAndFriendId(userId, friendId);

        List<MessageDto> messageDtoList = new ArrayList<>();
        for (Message message : messageList) {
            MessageDto messageDto = new MessageDto();
            messageDto.setFromUserId(message.getFromUserId());
            messageDto.setToUserId(message.getToUserId());
            messageDto.setMessageContent(message.getMessageContent());

            messageDtoList.add(messageDto);
        }

        return messageDtoList;
    }
}
