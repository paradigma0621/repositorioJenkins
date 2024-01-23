package com.paradigma0621.learning.service.chainofresponsability.complexity1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftExecutor {

    @Autowired
    Elo1 elo1;

    public String printMessageInScreen() {
        return elo1.create();
    }
}
