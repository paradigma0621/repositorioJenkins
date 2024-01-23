package com.paradigma0621.learning.service.chainofresponsability.chain;

import com.nexti.operationdesk.dto.load.ReplacementRepositoryDto;
import com.nexti.operationdesk.dto.response.card.PersonDataResponseDto;
import com.nexti.operationdesk.dto.response.card.PersonsCardDto;
import com.nexti.operationdesk.enums.PersonConditionEnum;
import com.nexti.operationdesk.service.person.card.FindPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.nexti.operationdesk.enums.PersonConditionEnum.EFFECTIVE;


@Service
public class FindPersonCardWhenEffectivePersonService implements PersonCardHandler {

    @Autowired
    private FindPersonService findPersonService;


    @Override
    public void setNext(PersonCardHandler handler) {
        // Não seta próximo elo da corrente pois esse é o último
    }

    @Override
    public PersonsCardDto handleRequest(Long mainPersonId, PersonConditionEnum personConditionEnum,
                                        ReplacementRepositoryDto replacementRepositoryDto) {

        PersonDataResponseDto mainPerson = findPersonService.getPersonDataResponseDto(mainPersonId, PersonConditionEnum.EFFECTIVE, null);
        PersonDataResponseDto vinculatedPerson = null;
        return new PersonsCardDto(mainPerson, vinculatedPerson);
    }

}