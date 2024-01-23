package com.paradigma0621.learning.service.chainofresponsability.chain;

import com.nexti.operationdesk.dto.load.ReplacementRepositoryDto;
import com.nexti.operationdesk.dto.response.card.PersonsCardDto;
import com.nexti.operationdesk.enums.PersonConditionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.nexti.operationdesk.enums.ReplacementTypeEnum.REPLACEMENT_REVERSE_SCHEDULE;
import static java.util.Objects.nonNull;

@Service
public class FindReverseScheduleService implements PersonCardHandler {

    @Autowired
    FindPersonCardWhenReverseScheduleService findPersonCardWhenReverseScheduleService;

    private PersonCardHandler next;

    @Override
    public void setNext(PersonCardHandler personCardHandler) {
        this.next = personCardHandler;
    }

    @Override
    public PersonsCardDto handleRequest(Long mainPersonId, PersonConditionEnum personConditionEnum,
                                        ReplacementRepositoryDto replacementRepositoryDto) {

        if (isChooseReverseScheduleLogic(replacementRepositoryDto)) {
            return findPersonCardWhenReverseScheduleService.getPersonCard(mainPersonId, replacementRepositoryDto);
        } else
            return next.handleRequest(mainPersonId, personConditionEnum, replacementRepositoryDto);
    }

    private static boolean isChooseReverseScheduleLogic(ReplacementRepositoryDto replacementRepositoryDto) {
        return nonNull(replacementRepositoryDto)
                && ReplacementTypeEnum.REPLACEMENT_REVERSE_SCHEDULE.getId().equals(replacementRepositoryDto.replacementTypeId());
    }
}
