package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.controllers.v1;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto.v1.PersonDtoV1;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.entities.Person;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.response.Response;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.services.PersonServiceInterface;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.mappers.v1.PersonMapperV1;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@CrossOrigin(origins = "*")
public class PersonControllerV1 {

    private static final Logger log = LoggerFactory.getLogger(PersonControllerV1.class);

    @Autowired
    private PersonServiceInterface personServiceInterface;

    /**
     * Create a new Person in the System.
     *
     * @param personDtoV1;
     * @param result;
     * @return ResponseEntity<Response < PersonDto>>;
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDtoV1>> create(@Valid @RequestBody PersonDtoV1 personDtoV1, BindingResult result) {
        log.info("[PersonController] - Adding Person {}", personDtoV1.toString());
        Response<PersonDtoV1> response = new Response<>();

        Person updatedPerson = personDtoV1.getId().isPresent() ? this.personServiceInterface.searchById(personDtoV1.getId().get()) : new Person();
        Person person = PersonMapperV1.generatePersonBasedOnPersonDto(personDtoV1, updatedPerson);

        if (result.hasErrors()) {
            log.error("[ERROR] - The current data validation was not successfully: {}", result.getAllErrors());
            result.getAllErrors().forEach(objectError -> response.getErrors().add(objectError.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(PersonMapperV1.generatePersonDto(this.personServiceInterface.create(person)));
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDtoV1>> findById(@PathVariable(value = "id") Long id) {
        Response<PersonDtoV1> response = new Response<>();
        response.setData(PersonMapperV1.generatePersonDto(this.personServiceInterface.searchById(id)));
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/firstName/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDtoV1>> findByFirstName(@PathVariable(value = "firstName") String firstName) {
        Response<PersonDtoV1> response = new Response<>();
        response.setData(PersonMapperV1.generatePersonDto(this.personServiceInterface.searchByName(firstName)));
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<PersonDtoV1>>> findAll() {
        Response<List<PersonDtoV1>> response = new Response<>();
        response.setData(PersonMapperV1.generatePersonDtoList(this.personServiceInterface.searchAll()));
        return ResponseEntity.ok(response);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDtoV1>> update(@RequestBody PersonDtoV1 personDtoV1, BindingResult result) {
        log.info("[PersonController] - Updating Person {}", personDtoV1.toString());
        Response<PersonDtoV1> response = new Response<>();
        Person updatedPerson = personDtoV1.getId().isPresent() ? this.personServiceInterface.searchById(personDtoV1.getId().get()) : new Person();
        Person person = PersonMapperV1.generatePersonBasedOnPersonDto(personDtoV1, updatedPerson);

        if (result.hasErrors()) {
            log.error("[ERROR] - The current data validation was not successfully: {}", result.getAllErrors());
            result.getAllErrors().forEach(objectError -> response.getErrors().add(objectError.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(PersonMapperV1.generatePersonDto(this.personServiceInterface.update(person)));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/id/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        this.personServiceInterface.delete(id);
        return ResponseEntity.noContent().build();
    }
}
