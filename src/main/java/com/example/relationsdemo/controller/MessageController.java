package com.example.relationsdemo.controller;

import com.example.relationsdemo.domain.Message;
import com.example.relationsdemo.repository.MessageRepository;
import com.example.relationsdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class MessageController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/messages")
    public Iterable<Message> getMessages() {
        return messageRepository.findAll();
    }

}
