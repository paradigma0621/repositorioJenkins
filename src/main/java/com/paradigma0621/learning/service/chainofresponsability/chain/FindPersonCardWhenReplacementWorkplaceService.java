package com.paradigma0621.learning.service.chainofresponsability.chain;

import com.nexti.operationdesk.dto.load.ReplacementRepositoryDto;
import com.nexti.operationdesk.dto.response.card.PersonDataResponseDto;
import com.nexti.operationdesk.dto.response.card.PersonsCardDto;
import com.nexti.operationdesk.enums.PersonConditionEnum;
import com.nexti.operationdesk.service.person.card.FindPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.nexti.operationdesk.enums.ReplacementTypeEnum.REPLACEMENT_WORKPLACE;
import static java.util.Objects.nonNull;

@Service
public class FindPersonCardWhenReplacementWorkplaceService implements PersonCardHandler {

    @Autowired
    private FindPersonService findPersonService;

    private PersonCardHandler next;

    @Override
    public void setNext(PersonCardHandler personCardHandler) {
        this.next = personCardHandler;
    }

    @Override
    public PersonsCardDto handleRequest(Long mainPersonId, PersonConditionEnum personConditionEnum,
                                        ReplacementRepositoryDto replacementRepositoryDto) {

        if (isChooseReplacementWorkplaceLogic(replacementRepositoryDto)) {
            PersonDataResponseDto mainPerson = findPersonService.getPersonDataResponseDto(mainPersonId,
                                                                                          personConditionEnum,
                                                                                          replacementRepositoryDto);
            return new PersonsCardDto(mainPerson, null);
        } else
            return next.handleRequest(mainPersonId, personConditionEnum, replacementRepositoryDto);
    }

    //TODO Borsatto se for manter essa chain: abstrair e padronizar essa lógica do se é o isRightLogic
    private static boolean isChooseReplacementWorkplaceLogic(ReplacementRepositoryDto replacementRepositoryDto) {
        return nonNull(replacementRepositoryDto)
                && ReplacementTypeEnum.REPLACEMENT_WORKPLACE.getId().equals(replacementRepositoryDto.replacementTypeId());
    }
}