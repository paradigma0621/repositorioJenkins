package com.paradigma0621.learning.service.chainofresponsability.complexity1;

import org.springframework.stereotype.Service;

@Service
public class Elo3 extends Shift {

    public Elo3() {
        nextShift = null;
    }

    @Override
    protected boolean isRightLogic() {
        return true;
    }

    @Override
    protected String createShift() {
        return "No elo 3";
    }
}
