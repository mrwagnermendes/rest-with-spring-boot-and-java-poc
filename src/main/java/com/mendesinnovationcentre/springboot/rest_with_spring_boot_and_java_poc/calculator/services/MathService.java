package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.calculator.services;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MathService {

    private final Logger log = Logger.getLogger(MathService.class.getName());

    public Double sum(Double numberOne, Double numberTwo) {
        log.info("[MATH - SUM] MathService operation being executed!");
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        log.info("[MATH - SUBTRACTION] MathService operation being executed!");
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        log.info("[MATH - MULTIPLICATION] MathService operation being executed!");
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        log.info("[MATH - DIVISION] MathService operation being executed!");
        return numberOne / numberTwo;
    }

    public Double average(Double numberOne, Double numberTwo) {
        log.info("[MATH - AVERAGE] MathService operation being executed!");
        return (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(Double numberOne) {
        log.info("[MATH - SQUARE_ROOT] MathService operation being executed!");
        return Math.sqrt(numberOne);
    }
}
