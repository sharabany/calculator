package com.shs.exercise.calculator.resource;

import com.shs.exercise.calculator.data.Calculator;
import org.springframework.stereotype.Service;


@Service
public class CalculatorResource {

    public String calculate(Calculator myCalculator) {
        String operation = myCalculator.getOperator();
        Integer x = myCalculator.getLeft(), y = myCalculator.getRight();
        Integer result = 0;
        String op = "";

        if ("plus".equals(operation)) {
            result = x + y;
            op = "+";
        } else if ("minus".equals(operation)) {
            result = x - y;
            op = "-";
        } else if ("multiply".equals(operation)) {
            result = x * y;
            op = "*";
        } else if ("divide".equals(operation)) {
            if (y == 0) {
                return ("Error. You can not divide in zero");
            }
            result = x / y;
            op = "/";
        }

        return String.format("%d %s %d = %d%n", x, op, y, result);
    }
}
