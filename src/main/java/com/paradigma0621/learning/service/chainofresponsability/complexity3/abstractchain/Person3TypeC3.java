package com.paradigma0621.learning.service.chainofresponsability.complexity3.abstractchain;

import com.paradigma0621.learning.dto.PersonDto;
import org.springframework.stereotype.Service;

@Service
public class Person3TypeC3 extends PersonCardC3 {

    public Person3TypeC3() {
        this.nextPersonCardC3 = null;
    }

    @Override
    protected boolean isRightLogic() {
        return true;
    }

    @Override
    protected PersonDto createPersonCard(Long id, String str1) {
        return findPersonServiceC3.getPersonDto(id, str1);
    }
}