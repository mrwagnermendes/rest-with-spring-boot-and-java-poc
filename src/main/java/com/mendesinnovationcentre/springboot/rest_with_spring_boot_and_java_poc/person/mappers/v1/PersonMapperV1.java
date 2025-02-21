package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.mappers.v1;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto.v1.PersonDtoV1;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.entities.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonMapperV1 {

    /**
     * Generate the Person object based on PersonDto parameter.
     *
     * @param personDtoV1;
     * @param updatedPerson;
     * @return Person;
     */
    public static Person generatePersonBasedOnPersonDto(PersonDtoV1 personDtoV1, Person updatedPerson) {
        if (personDtoV1.getId().isPresent()) {
            updatedPerson.setId(personDtoV1.getId().get());
        }

        updatedPerson.setFirstName(personDtoV1.getFirstName());
        updatedPerson.setLastName(personDtoV1.getLastName());
        updatedPerson.setGender(personDtoV1.getGender());
        updatedPerson.setAddress(personDtoV1.getAddress());

        return updatedPerson;
    }

    /**
     * Generate a PersonDto list Object based on Person data list.
     *
     * @param personList;
     * @return List<PersonDto>;
     */
    public static List<PersonDtoV1> generatePersonDtoList(List<Person> personList) {
        List<PersonDtoV1> personDtoV1List = new ArrayList<>();

        personList.forEach(person -> personDtoV1List.add(generatePersonDto(person)));
        return personDtoV1List;
    }

    /**
     * Generate a PersonDto Object based on Person data.
     *
     * @param person;
     * @return PersonDto;
     */
    public static PersonDtoV1 generatePersonDto(Person person) {
        PersonDtoV1 personDtoV1 = new PersonDtoV1();
        personDtoV1.setId(Optional.of(person.getId()));
        personDtoV1.setFirstName(person.getFirstName());
        personDtoV1.setLastName(person.getLastName());
        personDtoV1.setGender(person.getGender());
        personDtoV1.setAddress(person.getAddress());
        return personDtoV1;
    }
}
