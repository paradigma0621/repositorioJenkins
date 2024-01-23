package com.paradigma0621.learning.service.chainofresponsability.complexity2.abstractchain;

import com.paradigma0621.learning.dto.PersonDto;
import com.paradigma0621.learning.service.chainofresponsability.complexity2.service.FindPersonServiceC2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Person3TypeC2 extends PersonCardC2 {
    @Autowired
    protected FindPersonServiceC2 findPersonServiceC2;

    public Person3TypeC2() {
        this.nextPersonCardC2 = null;
    }

    @Override
    protected boolean isRightLogic() {
        return true;
    }

    @Override
    protected PersonDto createPersonCard(Long id, String str1) {
        return findPersonServiceC2.getPersonDto(id, str1);
    }
}