package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.services;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private static final AtomicLong COUNTER = new AtomicLong();

    private final Logger log = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        log.info("[PersonService] - Finding All People!");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        log.info("[PersonService] - Finding one Person!");
        Person person = new Person();
        person.setId(COUNTER.incrementAndGet());
        person.setFirstName("Wagner");
        person.setLastName("Mendes");
        person.setAddress("Mario Campos Barbosa. n6, Alverca d Ribatejo");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person) {
        log.info("[PersonService] - Creating one person!");
        return person;
    }

    public Person update(Person person) {
        log.info("[PersonService] - Updating one person!");
        return person;
    }

    public void delete(String id) {
        log.info("[PersonService] - Deleting one person!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(COUNTER.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in Brazil " + i);
        person.setGender("Male");
        return person;
    }
}
