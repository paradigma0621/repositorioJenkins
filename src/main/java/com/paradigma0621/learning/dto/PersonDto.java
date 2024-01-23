package com.paradigma0621.learning.dto;

public class PersonDto {
    private Long personId;
    private String personName;
    private Integer personAge;

    public PersonDto(Long personId, String personName, Integer personAge) {
        this.personId = personId;
        this.personName = personName;
        this.personAge = personAge;
    }

    public Long getPersonId() {
        return personId;
    }

    public PersonDto setPersonId(Long personId) {
        this.personId = personId;
        return this;
    }

    public String getPersonName() {
        return personName;
    }

    public PersonDto setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    public Integer getPersonAge() {
        return personAge;
    }

    public PersonDto setPersonAge(Integer personAge) {
        this.personAge = personAge;
        return this;
    }
}
