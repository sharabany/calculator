package com.shs.exercise.calculator.service;

import com.shs.exercise.calculator.data.Calculator;
import com.shs.exercise.calculator.interfaceAction.CalculatorActionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculatorService {

    @Autowired
    List<CalculatorActionInterface> calculatorActions;
    public static String UNKNOWN_OPERATOR = "operator '%s' is not supported." +
            "%nSupported operations are: plus, minus, multiply and divide";

    public String calculate(Calculator calculator) {
        Optional<CalculatorActionInterface> calculatorActionCurrent = calculatorActions.stream()
                .filter(calculatorAction -> calculatorAction.actionName().equals(calculator.getOperator()))
                .findFirst();

        return calculatorActionCurrent.isPresent() ?
                calculatorActionCurrent.get().action(calculator.getLeft(), calculator.getRight()) :
                String.format(UNKNOWN_OPERATOR, calculator.getOperator());
    }
}

