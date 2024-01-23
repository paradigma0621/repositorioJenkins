package com.paradigma0621.learning.service.chainofresponsability.chain;

import com.nexti.operationdesk.dto.load.ReplacementRepositoryDto;
import com.nexti.operationdesk.dto.response.card.PersonsCardDto;
import com.nexti.operationdesk.enums.PersonConditionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.nexti.operationdesk.enums.PersonConditionEnum.EFFECTIVE;
import static com.nexti.operationdesk.enums.ReplacementTypeEnum.REPLACEMENT_EMPLOYEE;
import static java.util.Objects.nonNull;

@Service
public class FindWhenEmployeeReplacementWhenEffectiveService implements PersonCardHandler {

    @Autowired
    private FindPersonCardWhenEmployeeReplacementWhenEffectiveService
            findPersonCardWhenEmployeeReplacementWhenEffectiveService;

    private PersonCardHandler next;

    @Override
    public void setNext(PersonCardHandler personCardHandler) {
        this.next = personCardHandler;
    }

    @Override
    public PersonsCardDto handleRequest(Long mainPersonId, PersonConditionEnum personConditionEnum,
                                        ReplacementRepositoryDto replacementRepositoryDto) {

        if (isChooseReplacementEmployeeWhenEffectiveLogic(personConditionEnum, replacementRepositoryDto)) {
            return findPersonCardWhenEmployeeReplacementWhenEffectiveService
                    .getPersonCard(mainPersonId, replacementRepositoryDto);
        } else
            return next.handleRequest(mainPersonId, personConditionEnum, replacementRepositoryDto);
    }

    private static boolean isChooseReplacementEmployeeWhenEffectiveLogic(
            PersonConditionEnum personConditionEnum, ReplacementRepositoryDto replacementRepositoryDto) {
        return nonNull(replacementRepositoryDto)
                && ReplacementTypeEnum.REPLACEMENT_EMPLOYEE.getId().equals(replacementRepositoryDto.replacementTypeId())
                && PersonConditionEnum.EFFECTIVE.equals(personConditionEnum)
                && (replacementRepositoryDto.isTakeTime() || replacementRepositoryDto.isEnterShiftManually());
    }
}