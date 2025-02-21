package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.services;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto.v1.PersonDtoV1;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class MockPersonService {

    private static final AtomicLong COUNTER = new AtomicLong();

    private final Logger log = Logger.getLogger(MockPersonService.class.getName());

    public List<PersonDtoV1> findAll() {
        log.info("[PersonService] - Finding All People!");
        List<PersonDtoV1> personDtoV1s = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            PersonDtoV1 personDtoV1 = mockPerson(i);
            personDtoV1s.add(personDtoV1);
        }
        return personDtoV1s;
    }

    public PersonDtoV1 findById(String id) {
        log.info("[PersonService] - Finding one Person!");
        PersonDtoV1 personDtoV1 = new PersonDtoV1();
     //   personDto.setId(COUNTER.incrementAndGet());
        personDtoV1.setFirstName("Wagner");
        personDtoV1.setLastName("Mendes");
        personDtoV1.setAddress("Mario Campos Barbosa. n6, Alverca d Ribatejo");
        personDtoV1.setGender("Male");
        return personDtoV1;
    }

    public PersonDtoV1 create(PersonDtoV1 personDtoV1) {
        log.info("[PersonService] - Creating one person!");
        return personDtoV1;
    }

    public PersonDtoV1 update(PersonDtoV1 personDtoV1) {
        log.info("[PersonService] - Updating one person!");
        return personDtoV1;
    }

    public void delete(String id) {
        log.info("[PersonService] - Deleting one person!");
    }

    private PersonDtoV1 mockPerson(int i) {
        PersonDtoV1 personDtoV1 = new PersonDtoV1();
     //   personDto.setId(COUNTER.incrementAndGet());
        personDtoV1.setFirstName("Person name " + i);
        personDtoV1.setLastName("Last name " + i);
        personDtoV1.setAddress("Some address in Brazil " + i);
        personDtoV1.setGender("Male");
        return personDtoV1;
    }
}
