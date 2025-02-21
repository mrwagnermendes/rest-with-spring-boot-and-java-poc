package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.mappers.v2;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto.v2.PersonDtoV2;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.entities.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonMapperV2 {

    /**
     * Generate the Person object based on PersonDto parameter.
     *
     * @param personDtoV2;
     * @param updatedPerson;
     * @return Person;
     */
    public static Person generatePersonBasedOnPersonDto(PersonDtoV2 personDtoV2, Person updatedPerson) {
        if (personDtoV2.getId().isPresent()) {
            updatedPerson.setId(personDtoV2.getId().get());
        }

        updatedPerson.setFirstName(personDtoV2.getFirstName());
        updatedPerson.setLastName(personDtoV2.getLastName());
        updatedPerson.setGender(personDtoV2.getGender());
        updatedPerson.setAddress(personDtoV2.getAddress());

        return updatedPerson;
    }

    /**
     * Generate a PersonDto list Object based on Person data list.
     *
     * @param personList;
     * @return List<PersonDto>;
     */
    public static List<PersonDtoV2> generatePersonDtoList(List<Person> personList) {
        List<PersonDtoV2> personDtoV2List = new ArrayList<>();

        personList.forEach(person -> personDtoV2List.add(generatePersonDto(person)));
        return personDtoV2List;
    }

    /**
     * Generate a PersonDto Object based on Person data.
     *
     * @param person;
     * @return PersonDto;
     */
    public static PersonDtoV2 generatePersonDto(Person person) {
        PersonDtoV2 personDtoV2 = new PersonDtoV2();
        personDtoV2.setId(Optional.of(person.getId()));
        personDtoV2.setFirstName(person.getFirstName());
        personDtoV2.setLastName(person.getLastName());
        personDtoV2.setGender(person.getGender());
        personDtoV2.setAddress(person.getAddress());
        personDtoV2.setBirthDay(new Date());
        return personDtoV2;
    }
}
