package com.paradigma0621.learning.service.chainofresponsability.complexity3.abstractchain;

import com.paradigma0621.learning.dto.PersonDto;
import com.paradigma0621.learning.service.chainofresponsability.complexity3.service.FindPersonServiceC3;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PersonCardC3 {

    @Autowired  // Diferença em relação ao outro caso do complexity2 foi que aqui eu declared a service na classe abstrata
    protected FindPersonServiceC3 findPersonServiceC3;

    protected PersonCardC3 nextPersonCardC3;

    public PersonDto create(Long id, String str1) {
        return isRightLogic() ? createPersonCard(id, str1) : nextPersonCardC3.create(id, str1);
    }

    protected abstract boolean isRightLogic();

    protected abstract PersonDto createPersonCard(Long id, String str1);

}
