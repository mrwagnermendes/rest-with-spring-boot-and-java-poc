package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.calculator.services;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.calculator.dto.MathDto;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(MathDto mathDto) {
        return mathDto.getNumberOne() + mathDto.getNumberTwo();
    }

    public Double subtraction(MathDto mathDto) {
        return mathDto.getNumberOne() - mathDto.getNumberTwo();
    }

    public Double multiplication(MathDto mathDto) {
        return mathDto.getNumberOne() * mathDto.getNumberTwo();
    }

    public Double division(MathDto mathDto) {
        return mathDto.getNumberOne() / mathDto.getNumberTwo();
    }

    public Double average(MathDto mathDto) {
        return (mathDto.getNumberOne() + mathDto.getNumberTwo()) / 2;
    }

    public Double squareRoot(MathDto mathDto) {
        return Math.sqrt(mathDto.getNumberOne());
    }
}
