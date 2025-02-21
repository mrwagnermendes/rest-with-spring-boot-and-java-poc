package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.controllers.v2;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto.v2.PersonDtoV2;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.mappers.v2.PersonMapperV2;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.response.Response;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.services.PersonServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/person")
@CrossOrigin(origins = "*")
public class PersonControllerV2 {

    private static final Logger log = LoggerFactory.getLogger(PersonControllerV2.class);

    @Autowired
    private PersonServiceInterface personServiceInterface;

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDtoV2>> findById(@PathVariable(value = "id") Long id) {
        Response<PersonDtoV2> response = new Response<>();
        response.setData(PersonMapperV2.generatePersonDto(this.personServiceInterface.searchById(id)));
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/firstName/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDtoV2>> findByFirstName(@PathVariable(value = "firstName") String firstName) {
        Response<PersonDtoV2> response = new Response<>();
        response.setData(PersonMapperV2.generatePersonDto(this.personServiceInterface.searchByName(firstName)));
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<PersonDtoV2>>> findAll() {
        Response<List<PersonDtoV2>> response = new Response<>();
        response.setData(PersonMapperV2.generatePersonDtoList(this.personServiceInterface.searchAll()));
        return ResponseEntity.ok(response);
    }
}
