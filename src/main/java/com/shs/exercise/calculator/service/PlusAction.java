package com.shs.exercise.calculator.service;

import com.shs.exercise.calculator.interfaceAction.CalculatorActionInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class PlusAction implements CalculatorActionInterface {

    @Override
    public String actionName() {
        return "plus";
    }

    @Override
    public String action(int x, int y) {
        return String.format("%d %s %d = %d", x, '+', y, x + y);
    }
}
