package com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.calculator.dto;

import com.mendesinnovationcentre.springboot.rest_with_spring_boot_and_java_poc.exceptions.UnsupportedMathOperationException;

public class MathDto {

    private final Double numberOne;
    private final Double numberTwo;

    public MathDto(String numberOne, String numberTwo) {
        this.numberOne = convertToDouble(numberOne);
        this.numberTwo = convertToDouble(numberTwo);
    }

    public Double getNumberOne() {
        return numberOne;
    }

    public Double getNumberTwo() {
        return numberTwo;
    }

    private static Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        } else {
            String number = strNumber.replaceAll(",", ".");
            if (isNumeric(number)) {
                return Double.parseDouble(number);
            } else {
                throw new UnsupportedMathOperationException("Please set a numeric value!");
            }
        }
    }

    private static boolean isNumeric(String strNumber) {
        if (strNumber == null) {
            return false;
        } else {
            String number = strNumber.replaceAll(",", ".");
            return number.matches("[-+]?[0-9]*\\.?[0-9]+");
        }
    }
}
