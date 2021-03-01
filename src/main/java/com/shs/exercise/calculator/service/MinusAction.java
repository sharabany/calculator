package com.shs.exercise.calculator.service;

import com.shs.exercise.calculator.interfaceAction.CalculatorActionInterface;
import org.springframework.stereotype.Component;

@Component
public class MinusAction implements CalculatorActionInterface {

    @Override
    public String actionName() {
        return "minus";
    }

    @Override
    public String action(int x, int y) {
        return String.format("%d %s %d = %d", x, '-', y, x - y);
    }
}
