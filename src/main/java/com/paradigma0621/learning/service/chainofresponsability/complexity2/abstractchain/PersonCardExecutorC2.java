package com.paradigma0621.learning.service.chainofresponsability.complexity2.abstractchain;

import com.paradigma0621.learning.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonCardExecutorC2 {
    @Autowired
    private Person1TypeC2 person1TypeC2;

    public PersonDto getPersonCard() {
        return person1TypeC2.create(12L, "anyString");
    }
}
