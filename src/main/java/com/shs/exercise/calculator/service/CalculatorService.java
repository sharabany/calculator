package com.shs.exercise.calculator.service;

import com.shs.exercise.calculator.data.Calculator;
import com.shs.exercise.calculator.data.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Locale;
import java.util.Map;

import static com.shs.exercise.calculator.data.Operator.*;

@Service
public class CalculatorService {
    @Autowired
    Map<Operator, Runnable> operationsMap;

    String result;
    Calculator myCalculator;
    Integer x, y;

    public String calculate(Calculator calculator) {

        myCalculator = calculator;
        x = myCalculator.getLeft();
        y = myCalculator.getRight();
        Operator operator;

        try {
            operator = valueOf(myCalculator.getOperator().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException illegalArgumentException) {
            return String.format("operator '%s' is not supported", myCalculator.getOperator());
        }

        operationsMap.get(operator).run();
        return result;

    }

    public void plus() {
        result = formatStringMessage("+", x + y);
    }

    public void minus() {
        result = formatStringMessage("-", x - y);
    }

    public void multiply() {
        result = formatStringMessage("*", x * y);
    }

    public void divide() {
        result = (y == 0) ?
                "Error - You can not divide in zero" :
                formatStringMessage("/", x / y);
    }

    private String formatStringMessage(String stringOperation, int result) {
        return String.format("%d %s %d = %d%n", x, stringOperation, y, result);
    }
}
