package com.paradigma0621.learning.controller;

import com.paradigma0621.learning.dto.PersonDto;
import com.paradigma0621.learning.service.chainofresponsability.complexity1.ShiftExecutor;
import com.paradigma0621.learning.service.chainofresponsability.complexity2.abstractchain.PersonCardExecutorC2;
import com.paradigma0621.learning.service.chainofresponsability.complexity3.abstractchain.PersonCardExecutorC3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chainOfResponsability")
public class ChainOfResponsability {

    @Autowired
    private ShiftExecutor shiftExecutor;
    @Autowired
    private PersonCardExecutorC2 personCardExecutorC2;
    @Autowired
    private PersonCardExecutorC3 personCardExecutorC3;

    @GetMapping("/complexity1")
    public String findChainOfResponsability1() {
        return shiftExecutor.printMessageInScreen();
    }

    @GetMapping("/complexity2")
    public PersonDto findChainOfResponsability2() {
        return personCardExecutorC2.getPersonCard();
    }

    @GetMapping("/complexity3")
    public PersonDto findChainOfResponsability3() {
        return personCardExecutorC3.getPersonCard();
    }

}
