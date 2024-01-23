package com.paradigma0621.learning.service.chainofresponsability.chain;

import com.nexti.operationdesk.dto.load.ReplacementRepositoryDto;
import com.nexti.operationdesk.dto.response.card.PersonDataResponseDto;
import com.nexti.operationdesk.dto.response.card.PersonsCardDto;
import com.nexti.operationdesk.enums.PersonConditionEnum;
import com.nexti.operationdesk.service.person.card.FindPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.nexti.operationdesk.enums.PersonConditionEnum.SUBSTITUTE;

@Service
public class FindPersonCardWhenEmployeeReplacementWhenAbsenteeService {

    @Autowired
    private FindPersonService findPersonService;

    public PersonsCardDto getPersonCard(Long mainPersonId, ReplacementRepositoryDto replacementRepositoryDto,
                                        PersonConditionEnum mainPersonConditionEnum)
    {
        PersonDataResponseDto mainPerson = findPersonService.getPersonDataResponseDto(mainPersonId,
                                                                                      mainPersonConditionEnum,
                                                                                      replacementRepositoryDto);
        PersonDataResponseDto vinculatedPerson = findPersonService
                .getPersonDataResponseDto(replacementRepositoryDto.substituteId(), PersonConditionEnum.SUBSTITUTE,
                                          replacementRepositoryDto);

        return new PersonsCardDto(mainPerson, vinculatedPerson);
    }

}