package com.shs.exercise.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorActions {

    public String DIVIDE_ERROR_MESSAGE = "Error - You can not divide in zero";

    public String plus(int x, int y) {
        return formatStringMessage(x, "+", y, x + y);
    }

    public String minus(int x, int y) {
        return formatStringMessage(x, "-", y, x - y);
    }

    public String multiply(int x, int y) {
        return formatStringMessage(x, "*", y, x * y);
    }

    public String divide(int x, int y) {
        return (y == 0) ?
                DIVIDE_ERROR_MESSAGE :
                formatStringMessage(x, "/", y, x / y);
    }

    private String formatStringMessage(int x, String stringOperation, int y, int result) {
        return String.format("%d %s %d = %d", x, stringOperation, y, result);
    }
}
