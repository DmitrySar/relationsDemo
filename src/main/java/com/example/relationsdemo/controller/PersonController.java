package com.example.relationsdemo.controller;

import com.example.relationsdemo.domain.Gender;
import com.example.relationsdemo.domain.Person;
import com.example.relationsdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController //возвращает объект в виде JSON
public class PersonController {

    @Autowired //добавляем экземпляр personRepository
    private PersonRepository personRepository;

    @GetMapping("/persons") //обрабатываем запрос HTTP GET
    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    @GetMapping("addperson")
//    RequestParam - получение данных по HTTP
    public void addPerson(@RequestParam String lastname,
                          @RequestParam String name,
                          @RequestParam String surname,
                          @RequestParam String gender,
                          @RequestParam String birthday) {

        Person person = new Person(lastname, name, surname, Gender.valueOf(gender), LocalDate.parse(birthday));
        //Запись данных в БД
        personRepository.save(person);

    }
}
