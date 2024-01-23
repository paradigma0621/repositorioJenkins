package com.paradigma0621.learning.service.chainofresponsability.complexity1;

public abstract class Shift {

    protected Shift nextShift;

    protected String create() {
        return isRightLogic() ? createShift() : nextShift.create();
    }

    protected abstract boolean isRightLogic();

    protected abstract String createShift();
}
