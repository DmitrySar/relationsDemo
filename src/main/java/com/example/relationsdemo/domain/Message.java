package com.example.relationsdemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Message {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String body;
    private LocalDateTime time;
    @ManyToOne
    private Person person;

    public Message(String title, String body, LocalDateTime time) {
        this.title = title;
        this.body = body;
        this.time = time;
    }
}
