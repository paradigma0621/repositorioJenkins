package com.paradigma0621.learning.service.chainofresponsability.chain;

import com.nexti.operationdesk.dto.load.ReplacementRepositoryDto;
import com.nexti.operationdesk.dto.response.card.PersonDataResponseDto;
import com.nexti.operationdesk.dto.response.card.PersonsCardDto;
import com.nexti.operationdesk.service.person.card.FindPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.nexti.operationdesk.enums.PersonConditionEnum.ABSENTEE;
import static com.nexti.operationdesk.enums.PersonConditionEnum.SUBSTITUTE;

@Service
public class FindPersonCardWhenReverseScheduleService {

    @Autowired
    private FindPersonService findPersonService;

    public PersonsCardDto getPersonCard(Long mainPersonId, ReplacementRepositoryDto replacementRepositoryDto) {
        PersonDataResponseDto mainPerson = findPersonService.getPersonDataResponseDto(mainPersonId, PersonConditionEnum.SUBSTITUTE,
                                                                                      replacementRepositoryDto);
        PersonDataResponseDto vinculatedPerson = findVinculatedPerson(replacementRepositoryDto);
        return new PersonsCardDto(mainPerson, vinculatedPerson);
    }

    private PersonDataResponseDto findVinculatedPerson(ReplacementRepositoryDto replacementRepositoryDto) {
        Long vinculatedPersonId = getOtherPersonId(replacementRepositoryDto);
        return findPersonService.getPersonDataResponseDto(vinculatedPersonId, PersonConditionEnum.ABSENTEE, replacementRepositoryDto);
    }

    private static Long getOtherPersonId(ReplacementRepositoryDto replacementRepositoryDto) {
        return replacementRepositoryDto.personId().equals(replacementRepositoryDto.absenteeId()) ?
                replacementRepositoryDto.substituteId() : replacementRepositoryDto.absenteeId();
     }

}
