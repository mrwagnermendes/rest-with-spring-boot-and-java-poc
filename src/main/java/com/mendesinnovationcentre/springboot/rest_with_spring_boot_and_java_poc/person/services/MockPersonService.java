package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.services;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class MockPersonService {

    private static final AtomicLong COUNTER = new AtomicLong();

    private final Logger log = Logger.getLogger(MockPersonService.class.getName());

    public List<PersonDto> findAll() {
        log.info("[PersonService] - Finding All People!");
        List<PersonDto> personDtos = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            PersonDto personDto = mockPerson(i);
            personDtos.add(personDto);
        }
        return personDtos;
    }

    public PersonDto findById(String id) {
        log.info("[PersonService] - Finding one Person!");
        PersonDto personDto = new PersonDto();
     //   personDto.setId(COUNTER.incrementAndGet());
        personDto.setFirstName("Wagner");
        personDto.setLastName("Mendes");
        personDto.setAddress("Mario Campos Barbosa. n6, Alverca d Ribatejo");
        personDto.setGender("Male");
        return personDto;
    }

    public PersonDto create(PersonDto personDto) {
        log.info("[PersonService] - Creating one person!");
        return personDto;
    }

    public PersonDto update(PersonDto personDto) {
        log.info("[PersonService] - Updating one person!");
        return personDto;
    }

    public void delete(String id) {
        log.info("[PersonService] - Deleting one person!");
    }

    private PersonDto mockPerson(int i) {
        PersonDto personDto = new PersonDto();
     //   personDto.setId(COUNTER.incrementAndGet());
        personDto.setFirstName("Person name " + i);
        personDto.setLastName("Last name " + i);
        personDto.setAddress("Some address in Brazil " + i);
        personDto.setGender("Male");
        return personDto;
    }
}
