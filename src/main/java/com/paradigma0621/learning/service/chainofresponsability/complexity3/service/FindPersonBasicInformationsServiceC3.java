package com.paradigma0621.learning.service.chainofresponsability.complexity3.service;

import com.paradigma0621.learning.dto.PersonDto;
import org.springframework.stereotype.Service;

@Service
public class FindPersonBasicInformationsServiceC3 {

    public PersonDto getBasicInformations(Long id, String str1) {
        return new PersonDto(123L, "João Pedro", 8);
    }

}
