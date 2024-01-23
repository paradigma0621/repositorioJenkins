package com.paradigma0621.learning.service.chainofresponsability.complexity2.service;

import com.paradigma0621.learning.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPersonServiceC2 {

    @Autowired
    private FindPersonBasicInformationsServiceC2 findPersonBasicInformationsServiceC2;

    public PersonDto getPersonDto(Long id, String str1) {
        return findPersonBasicInformationsServiceC2.getBasicInformations(id, str1);
    }

}
