package com.codexmo.firstservice.service.Impl;

import com.codexmo.firstservice.model.User;
import com.codexmo.firstservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Override
    public void sendUser() {
        User user = new User("Thilan", "Madusanka", "thilan87189@gmail.com", "+46123123123");
        kafkaTemplate.send(topicName, user);
    }
}
