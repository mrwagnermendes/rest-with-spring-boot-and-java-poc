package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.utils;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto.PersonDto;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonParseUtil {

    public PersonParseUtil() {
    }

    /**
     * Generate the Person object based on PersonDto parameter.
     *
     * @param personDto;
     * @param updatedPerson;
     * @return Person;
     */
    public static Person generatePersonBasedOnPersonDto(PersonDto personDto, Person updatedPerson) {
        if (personDto.getId().isPresent()) {
            updatedPerson.setId(personDto.getId().get());
        }

        updatedPerson.setFirstName(personDto.getFirstName());
        updatedPerson.setLastName(personDto.getLastName());
        updatedPerson.setGender(personDto.getGender());
        updatedPerson.setAddress(personDto.getAddress());

        return updatedPerson;
    }

    /**
     * Generate a PersonDto list Object based on Person data list.
     *
     * @param personList;
     * @return List<PersonDto>;
     */
    public static List<PersonDto> generatePersonDtoList(List<Person> personList) {
        List<PersonDto> personDtoList = new ArrayList<>();

        personList.forEach(person -> personDtoList.add(generatePersonDto(person)));
        return personDtoList;
    }

    /**
     * Generate a PersonDto Object based on Person data.
     *
     * @param person;
     * @return PersonDto;
     */
    public static PersonDto generatePersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(Optional.of(person.getId()));
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setGender(person.getGender());
        personDto.setAddress(person.getAddress());
        return personDto;
    }
}
