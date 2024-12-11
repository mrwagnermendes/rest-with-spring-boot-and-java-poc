package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.calculator.controllers;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.calculator.dto.MathDto;
import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.calculator.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    private MathService service;

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        MathDto mathDto = new MathDto(numberOne, numberTwo);
        return service.sum(mathDto);
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
                              @PathVariable(value = "numberTwo") String numberTwo) {

        MathDto mathDto = new MathDto(numberOne, numberTwo);
        return service.subtraction(mathDto);
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) {

        MathDto mathDto = new MathDto(numberOne, numberTwo);
        return service.multiplication(mathDto);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) {

        MathDto mathDto = new MathDto(numberOne, numberTwo);
        return service.division(mathDto);
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable(value = "numberOne") String numberOne,
                          @PathVariable(value = "numberTwo") String numberTwo) {

        MathDto mathDto = new MathDto(numberOne, numberTwo);
        return service.average(mathDto);
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number) {
        MathDto mathDto = new MathDto(number, null);
        return service.squareRoot(mathDto);
    }
}
