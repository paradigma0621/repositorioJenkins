package com.paradigma0621.learning.service.chainofresponsability.complexity3.service;

import com.paradigma0621.learning.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPersonServiceC3 {

    @Autowired
    private FindPersonBasicInformationsServiceC3 findPersonBasicInformationsServiceC3;

    public PersonDto getPersonDto(Long id, String str1) {
        return findPersonBasicInformationsServiceC3.getBasicInformations(id, str1);
    }

}
