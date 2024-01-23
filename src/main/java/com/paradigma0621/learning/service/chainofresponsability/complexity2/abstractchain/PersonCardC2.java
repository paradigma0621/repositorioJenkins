package com.paradigma0621.learning.service.chainofresponsability.complexity2.abstractchain;

import com.paradigma0621.learning.dto.PersonDto;

public abstract class PersonCardC2 {

    protected PersonCardC2 nextPersonCardC2;

    public PersonDto create(Long id, String str1) {
        return isRightLogic() ? createPersonCard(id, str1) : nextPersonCardC2.create(id, str1);
    }

    protected abstract boolean isRightLogic();

    protected abstract PersonDto createPersonCard(Long id, String str1);

}
