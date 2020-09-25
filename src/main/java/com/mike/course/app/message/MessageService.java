package com.mike.course.app.message;

import com.mike.course.app.mapper.MessageMapper;
import com.mike.course.app.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserService userService;

    @Transactional
    public void sendMessage(MessageDto messageDto) {
        messageRepository.save(MessageMapper.from(messageDto));
    }

    List<MessageDto> getMessage(String email, Long friendId) {
        Long userId = userService.getUserIdByEmail(email);
        return MessageMapper.from(messageRepository.getAllByUserIdAndFriendId(userId, friendId));
    }
}
