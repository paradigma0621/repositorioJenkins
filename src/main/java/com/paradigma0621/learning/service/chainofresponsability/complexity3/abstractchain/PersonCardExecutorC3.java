package com.paradigma0621.learning.service.chainofresponsability.complexity3.abstractchain;

import com.paradigma0621.learning.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonCardExecutorC3 {
    @Autowired
    private Person1TypeC3 person1TypeC3;

    public PersonDto getPersonCard() {
        return person1TypeC3.create(12L, "anyString");
    }
}
