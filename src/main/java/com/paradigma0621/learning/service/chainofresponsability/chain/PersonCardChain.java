package com.paradigma0621.learning.service.chainofresponsability.chain;

import com.nexti.operationdesk.dto.response.card.PersonsCardDto;
import com.nexti.operationdesk.service.person.card.FindReplacementRepositoryDtoService;
import com.nexti.operationdesk.service.person.card.PersonCardParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class PersonCardChain {
    @Autowired
    private FindPersonCardWhenReplacementShiftService findPersonCardWhenReplacementShiftService;
    @Autowired
    private FindPersonCardWhenReplacementWorkplaceService findPersonCardWhenReplacementWorkplaceService;
    @Autowired
    private FindReverseScheduleService findReverseScheduleService;
    @Autowired
    private FindWhenEmployeeReplacementWhenAbsenteeService findWhenEmployeeReplacementWhenAbsenteeService;
    @Autowired
    private FindWhenEmployeeReplacementWhenEffectiveService findWhenEmployeeReplacementWhenEffectiveService;
    @Autowired
    private FindPersonCardWhenEffectivePersonService findPersonCardWhenEffectivePersonService;
    @Autowired
    private FindReplacementRepositoryDtoService findReplacementRepositoryDtoService;

    public PersonsCardDto process(PersonCardParamDto personCardParamDto) {
        Long personId = personCardParamDto.personId();
        Long workplaceId = personCardParamDto.workplaceId();
        Long replacementId = personCardParamDto.replacementId();
        var replacementRepositoryDto = isNull(replacementId) ?
                findReplacementRepositoryDtoService.getReplacementRepositoryDtoWithoutReplacementIdBy(personId, workplaceId)
                : findReplacementRepositoryDtoService.getReplacementRepositoryDtoBy(personId, workplaceId, replacementId);

        createChain();
        return findPersonCardWhenReplacementShiftService.handleRequest(personId, personCardParamDto.personConditionEnum(),
                                                                       replacementRepositoryDto);
    }

    private void createChain() {
        findPersonCardWhenReplacementShiftService.setNext(findPersonCardWhenReplacementWorkplaceService);
        findPersonCardWhenReplacementWorkplaceService.setNext(findReverseScheduleService);
        findReverseScheduleService.setNext(findWhenEmployeeReplacementWhenAbsenteeService);
        findWhenEmployeeReplacementWhenAbsenteeService.setNext(findWhenEmployeeReplacementWhenEffectiveService);
        findWhenEmployeeReplacementWhenEffectiveService.setNext(findPersonCardWhenEffectivePersonService);
    }
}