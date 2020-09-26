package com.mike.course.app.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendMessage(@RequestBody @Valid MessageDto messageDto) {
        messageService.sendMessage(messageDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MessageDto> getMessage(@RequestHeader(value = "email") String email,
                                       @RequestHeader(value = "friendId") Long friendId) {
        return messageService.getMessage(email, friendId);
    }
}
