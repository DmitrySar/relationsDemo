package com.example.relationsdemo.controller;

import com.example.relationsdemo.domain.Message;
import com.example.relationsdemo.domain.Person;
import com.example.relationsdemo.repository.MessageRepository;
import com.example.relationsdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
public class MessageController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/messages")
    public Iterable<Message> getMessages(@RequestParam int personId) {
        return personRepository.findById(personId).get().getMessages();
    }

    @GetMapping("/addmessage")
    public void addMessage(@RequestParam int personId,
                           @RequestParam String title,
                           @RequestParam String body) {
        Person person = personRepository.findById(personId).get();
        Message message = new Message(person, title, body, LocalDateTime.now());
        person.addMessage(message);
        personRepository.save(person);
    }

}
