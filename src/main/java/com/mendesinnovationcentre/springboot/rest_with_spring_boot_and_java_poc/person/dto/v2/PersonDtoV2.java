package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.person.dto.v2;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class PersonDtoV2 {

    private Optional<Long> id = Optional.empty();
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthDay;

    public PersonDtoV2() {
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDtoV2 personDtoV2 = (PersonDtoV2) o;
        return Objects.equals(id, personDtoV2.id)
                && Objects.equals(firstName, personDtoV2.firstName)
                && Objects.equals(lastName, personDtoV2.lastName)
                && Objects.equals(address, personDtoV2.address)
                && Objects.equals(gender, personDtoV2.gender)
                && Objects.equals(birthDay, personDtoV2.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender, birthDay);
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
