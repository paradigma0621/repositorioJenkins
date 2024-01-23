package com.paradigma0621.learning.service.chainofresponsability.complexity1;

import org.springframework.stereotype.Service;

@Service
public class Elo1 extends Shift {

    public Elo1(Elo2 nextShift) {
        this.nextShift = nextShift;
    }

    @Override
    protected boolean isRightLogic() {
        return false;
    }

    @Override
    protected String createShift() {
        return "Elo 1, que não será chamado";
    }
}
