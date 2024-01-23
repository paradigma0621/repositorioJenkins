package com.paradigma0621.learning.service.chainofresponsability.complexity1;

import org.springframework.stereotype.Service;

@Service
public class Elo2 extends Shift {

    public Elo2(Elo3 nextShift) {
        this.nextShift = nextShift;
    }

    @Override
    protected boolean isRightLogic() {
        return false;
    }

    @Override
    protected String createShift() {
        return "No elo 2, que também não será chamado";
    }
}
