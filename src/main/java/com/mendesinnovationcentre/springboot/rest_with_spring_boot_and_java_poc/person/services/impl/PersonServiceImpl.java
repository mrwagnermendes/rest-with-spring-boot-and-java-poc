package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.services.impl;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.exceptions.ResourceNotFoundException;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.entities.Person;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.repositories.PersonRepository;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.services.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServiceImpl implements PersonServiceInterface {

    private final Logger log = Logger.getLogger(PersonServiceImpl.class.getName());

    @Autowired
    private PersonRepository personRepository;

    /**
     * Create and save a new Person on DB.
     *
     * @return List<Person>;
     */
    @Override
    public Person create(Person person) {
        log.info("[PersonServiceImpl] Saving Person: {" + person + "}");
        return this.personRepository.save(person);
    }

    /**
     * Returns a Person list based on All Person Dataset.
     *
     * @return List<Person>;
     */
    @Override
    public List<Person> searchAll() {
        log.info("[PersonServiceImpl] Searching All People");
        try {
            return personRepository.findAll();
        } catch (EmptyResultDataAccessException exception) {
            log.info("[PersonServiceImpl] Nobody found on DataBase instance!!!");
            throw new ResourceNotFoundException("[PersonServiceImpl] - Nobody found on DataBase instance!!!");
        }
    }

    /**
     * Returns a Person based on ID.
     *
     * @param id ;
     * @return Person;
     */
    @Override
    public Person searchById(Long id) {
        log.info("[PersonServiceImpl] Searching a Person based on id: {" + id + "}");
        return personRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("[PersonServiceImpl] - Person didn't find"));
    }

    /**
     * Returns a Person based on NAME.
     *
     * @param name ;
     * @return Person;
     */
    @Override
    public Person searchByName(String name) {
        log.info("[PersonServiceImpl] Searching a Person based on name: {" + name + "}");
        return personRepository.findByFirstName(name).orElseThrow(() ->
                new ResourceNotFoundException("[PersonServiceImpl] - Person didn't find"));
    }

    /**
     * Update and save a new Person on DB.
     *
     * @return List<Person>;
     */
    @Override
    public Person update(Person person) {
        log.info("[PersonServiceImpl] Updating Person: {" + person + "}");
        return this.personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        log.info("[PersonServiceImpl] Deleting Person: {" + id + "}");
        this.personRepository.deleteById(id);
    }
}
