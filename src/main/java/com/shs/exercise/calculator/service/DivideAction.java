package com.shs.exercise.calculator.service;

import com.shs.exercise.calculator.interfaceAction.CalculatorActionInterface;
import org.springframework.stereotype.Component;

@Component
public class DivideAction implements CalculatorActionInterface {

    public String DIVIDE_ERROR_MESSAGE = "Error - You can not divide in zero";

    @Override
    public String actionName() {
        return "divide";
    }

    @Override
    public String action(int x, int y) {
        return (y == 0) ?
                DIVIDE_ERROR_MESSAGE :
                String.format("%d %s %d = %d", x, '/', y, x / y);
    }
}
