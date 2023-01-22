package com.codexmo.firstservice.controller;

import com.codexmo.firstservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;


    @GetMapping("")
    public User getUserList() {
        User user = new User("Thilan", "Madusanka", "thilan87189@gmail.com", "+46123123123");
        kafkaTemplate.send(topicName, user.toString());
        return user;
    }


}
