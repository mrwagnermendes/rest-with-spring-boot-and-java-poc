package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.services;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.entities.Person;

import java.util.List;

public interface PersonServiceInterface {

    /**
     * Create a Person on the DataBase.
     *
     * @param person ;
     * @return Person;
     */
    Person create(Person person);

    /**
     * Returns All People registered.
     *
     * @return List < Person>;
     */
    List<Person> searchAll();

    /**
     * Returns a Person based on id.
     *
     * @param id ;
     * @return Optional<Person>;
     */
    Person searchById(Long id);

    /**
     * Returns a Person based on name.
     *
     * @param name ;
     * @return Person;
     */
    Person searchByName(String name);

    /**
     * Update a Person on the DataBase.
     *
     * @param person ;
     * @return Person;
     */
    Person update(Person person);

    /**
     * Delete a Person based on id.
     *
     * @param id ;
     */
    void delete(Long id);
}
