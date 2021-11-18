package com.example.relationsdemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity //Указывает, что данный бин (класс) является сущностью.
@NoArgsConstructor //создание конструктора без параметров
@Data //Создание геттеров и сеттеров
public class Person {
    @Id //id колонки
    @GeneratedValue //автоматический расчёт значения id
    private int id;
    private String lastname;
    private String name;
    private String surname;
    private Gender gender;
    private LocalDate birthday;
    @OneToMany
    private List<Message> messages = new ArrayList<>();

    //конструктор с параметрами
    public Person(String lastname, String name, String surname, Gender gender, LocalDate birthday) {
        this.lastname = lastname;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}
