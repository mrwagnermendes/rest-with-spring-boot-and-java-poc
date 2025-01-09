package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.calculator.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MathService.class);

    public Double sum(Double numberOne, Double numberTwo) {
        LOGGER.info("[MATH - SUM] MathService operation being executed!");
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        LOGGER.info("[MATH - SUBTRACTION] MathService operation being executed!");
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        LOGGER.info("[MATH - MULTIPLICATION] MathService operation being executed!");
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        LOGGER.info("[MATH - DIVISION] MathService operation being executed!");
        return numberOne / numberTwo;
    }

    public Double average(Double numberOne, Double numberTwo) {
        LOGGER.info("[MATH - AVERAGE] MathService operation being executed!");
        return (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(Double numberOne) {
        LOGGER.info("[MATH - SQUARE_ROOT] MathService operation being executed!");
        return Math.sqrt(numberOne);
    }
}
