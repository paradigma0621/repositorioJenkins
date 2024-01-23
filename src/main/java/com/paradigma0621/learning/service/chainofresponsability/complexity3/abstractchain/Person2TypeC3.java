package com.paradigma0621.learning.service.chainofresponsability.complexity3.abstractchain;

import com.paradigma0621.learning.dto.PersonDto;
import org.springframework.stereotype.Service;

@Service
public class Person2TypeC3 extends PersonCardC3 {

    public Person2TypeC3(Person3TypeC3 nextPersonCard) {
        this.nextPersonCardC3 = nextPersonCard;
    }

    @Override
    protected boolean isRightLogic() {
        return false;
    }

    @Override
    protected PersonDto createPersonCard(Long id, String str1) {
        return findPersonServiceC3.getPersonDto(id, str1);
    }
}