package com.paradigma0621.learning.service.chainofresponsability.chain;

import com.nexti.operationdesk.dto.load.ReplacementRepositoryDto;
import com.nexti.operationdesk.dto.response.card.PersonsCardDto;
import com.nexti.operationdesk.enums.PersonConditionEnum;
import com.nexti.operationdesk.service.person.card.FindReplacementRepositoryDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.nexti.operationdesk.enums.PersonConditionEnum.ABSENTEE;
import static com.nexti.operationdesk.enums.ReplacementTypeEnum.REPLACEMENT_EMPLOYEE;
import static java.util.Objects.nonNull;

@Service
public class FindWhenEmployeeReplacementWhenAbsenteeService implements PersonCardHandler {

    @Autowired
    private FindPersonCardWhenEmployeeReplacementWhenAbsenteeService
            findPersonCardWhenEmployeeReplacementWhenAbsenteeService;

    private PersonCardHandler next;

    @Override
    public void setNext(PersonCardHandler personCardHandler) {
        this.next = personCardHandler;
    }

    @Override
    public PersonsCardDto handleRequest(Long mainPersonId, PersonConditionEnum personConditionEnum,
                                        ReplacementRepositoryDto replacementRepositoryDto) {
        if ( isChooseReplacementEmployeeWhenAbsenteeLogic(replacementRepositoryDto, personConditionEnum)) {
            return findPersonCardWhenEmployeeReplacementWhenAbsenteeService.getPersonCard(mainPersonId,
                                                        replacementRepositoryDto, personConditionEnum);
        } else
            return next.handleRequest(mainPersonId, personConditionEnum, replacementRepositoryDto);
    }

    private static boolean isChooseReplacementEmployeeWhenAbsenteeLogic(ReplacementRepositoryDto replacementRepositoryDto,
                                                                PersonConditionEnum personConditionEnum) {
        return nonNull(replacementRepositoryDto)
                && ReplacementTypeEnum.REPLACEMENT_EMPLOYEE.getId().equals(replacementRepositoryDto.replacementTypeId())
                && PersonConditionEnum.ABSENTEE.equals(personConditionEnum);
    }
}