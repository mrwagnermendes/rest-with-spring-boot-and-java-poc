package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.repositories;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
@EnableJpaRepositories
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByFirstName(String firstName);
}
