package com.paradigma0621.learning.service.chainofresponsability.chain;

import com.nexti.operationdesk.dto.load.ReplacementRepositoryDto;
import com.nexti.operationdesk.dto.response.card.PersonDataResponseDto;
import com.nexti.operationdesk.dto.response.card.PersonsCardDto;
import com.nexti.operationdesk.service.person.card.FindPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.nexti.operationdesk.enums.PersonConditionEnum.EFFECTIVE;

@Service
public class FindPersonCardWhenEmployeeReplacementWhenEffectiveService {

    @Autowired
    private FindPersonService findPersonService;

    public PersonsCardDto getPersonCard(Long mainPersonId, ReplacementRepositoryDto replacementRepositoryDto) {
        PersonDataResponseDto mainPerson = findPersonService.getPersonDataResponseDto(mainPersonId, PersonConditionEnum.EFFECTIVE,
                                                                                      replacementRepositoryDto);

        PersonDataResponseDto vinculatedPerson = null;
        return new PersonsCardDto(mainPerson, vinculatedPerson);
    }
}