package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.controllers;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto.PersonDto;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.entities.Person;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.response.Response;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.services.PersonServiceInterface;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.utils.PersonParseUtil;
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
@RequestMapping("/api/person")
@CrossOrigin(origins = "*")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonServiceInterface personServiceInterface;

    /**
     * Create a new Person in the System.
     *
     * @param personDto;
     * @param result;
     * @return ResponseEntity<Response < PersonDto>>;
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDto>> create(@Valid @RequestBody PersonDto personDto, BindingResult result) {
        log.info("[PersonController] - Adding Person {}", personDto.toString());
        Response<PersonDto> response = new Response<>();

        Person updatedPerson = personDto.getId().isPresent() ? this.personServiceInterface.searchById(personDto.getId().get()) : new Person();
        Person person = PersonParseUtil.generatePersonBasedOnPersonDto(personDto, updatedPerson);

        if (result.hasErrors()) {
            log.error("[ERROR] - The current data validation was not successfully: {}", result.getAllErrors());
            result.getAllErrors().forEach(objectError -> response.getErrors().add(objectError.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(PersonParseUtil.generatePersonDto(this.personServiceInterface.create(person)));
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDto>> findById(@PathVariable(value = "id") Long id) {
        Response<PersonDto> response = new Response<>();
        response.setData(PersonParseUtil.generatePersonDto(this.personServiceInterface.searchById(id)));
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/firstName/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDto>> findByFirstName(@PathVariable(value = "firstName") String firstName) {
        Response<PersonDto> response = new Response<>();
        response.setData(PersonParseUtil.generatePersonDto(this.personServiceInterface.searchByName(firstName)));
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<PersonDto>>> findAll() {
        Response<List<PersonDto>> response = new Response<>();
        response.setData(PersonParseUtil.generatePersonDtoList(this.personServiceInterface.searchAll()));
        return ResponseEntity.ok(response);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDto>> update(@RequestBody PersonDto personDto, BindingResult result) {
        log.info("[PersonController] - Updating Person {}", personDto.toString());
        Response<PersonDto> response = new Response<>();
        Person updatedPerson = personDto.getId().isPresent() ? this.personServiceInterface.searchById(personDto.getId().get()) : new Person();
        Person person = PersonParseUtil.generatePersonBasedOnPersonDto(personDto, updatedPerson);

        if (result.hasErrors()) {
            log.error("[ERROR] - The current data validation was not successfully: {}", result.getAllErrors());
            result.getAllErrors().forEach(objectError -> response.getErrors().add(objectError.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(PersonParseUtil.generatePersonDto(this.personServiceInterface.update(person)));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/id/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        this.personServiceInterface.delete(id);
        return ResponseEntity.noContent().build();
    }
}
