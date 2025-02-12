package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;
import java.util.Optional;

public class PersonDto {

    private Optional<Long> id = Optional.empty();
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public PersonDto() {
    }

    public Optional<Long> getId() {
        return id;
    }

    public void setId(Optional<Long> id) {
        this.id = id;
    }

    @NotEmpty(message = "First Name can't be empty.")
    @Length(min = 3, max = 200, message = "First Name should contain among 3 and 200 characters.")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty(message = "Last Name can't be empty.")
    @Length(min = 3, max = 200, message = "Last Name should contain among 3 and 200 characters.")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotEmpty(message = "Address can't be empty.")
    @Length(min = 3, max = 200, message = "Address should contain among 3 and 200 characters.")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @NotEmpty(message = "Gender can't be empty.")
    @Length(min = 3, max = 200, message = "Gender should contain among 3 and 200 characters.")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(id, personDto.id)
                && Objects.equals(firstName, personDto.firstName)
                && Objects.equals(lastName, personDto.lastName)
                && Objects.equals(address, personDto.address)
                && Objects.equals(gender, personDto.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}
