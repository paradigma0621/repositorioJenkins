package com.paradigma0621.learning.service.chainofresponsability.complexity2.abstractchain;

import com.paradigma0621.learning.dto.PersonDto;
import com.paradigma0621.learning.service.chainofresponsability.complexity2.service.FindPersonServiceC2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Person1TypeC2 extends PersonCardC2 {
    @Autowired
    protected FindPersonServiceC2 findPersonServiceC2;

    public Person1TypeC2(Person2TypeC2 nextPersonCard) {
        this.nextPersonCardC2 = nextPersonCard;
    }

    @Override
    protected boolean isRightLogic() {
        return false;
    }

    @Override
    protected PersonDto createPersonCard(Long id, String str1) {
        return findPersonServiceC2.getPersonDto(id, str1);
    }
}