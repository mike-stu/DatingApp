package com.mike.course.app.hobby;

import com.mike.course.app.exception.InvalidHobbyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hobby")
public class HobbyController {

    @Autowired
    HobbyService hobbyService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addHobby(@RequestBody @Valid HobbyDto hobbyDto) throws InvalidHobbyException {
        hobbyService.addHobby(hobbyDto);
    }

    @GetMapping("/{userId}")
    public List<HobbyDto> getHobbyByUser(@PathVariable Long userId) {
        return hobbyService.getAllHobby(userId);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteHobby(@RequestBody @Valid HobbyDto hobbyDto) {
        hobbyService.deleteHobby(hobbyDto);
    }
}


