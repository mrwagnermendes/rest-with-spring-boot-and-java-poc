package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.services;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private static final AtomicLong counter = new AtomicLong();

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("[PersonService] - Finding one Person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Wagner");
        person.setLastName("Mendes");
        person.setAddress("Mario Campos Barbosa. n6, Alverca d Ribatejo");
        person.setGender("Malle");
        return person;
    }

    public List<Person> findAll() {
        logger.info("[PersonService] - Finding All People!");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person) {
        logger.info("[PersonService] - Creating one person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("[PersonService] - Updating one person!");
        return person;
    }

    public void delete(String id) {
        logger.info("[PersonService] - Deleting one person!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in Brazil " + i);
        person.setGender("Malle");
        return person;
    }
}
