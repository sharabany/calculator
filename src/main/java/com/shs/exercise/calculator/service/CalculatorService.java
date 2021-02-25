package com.shs.exercise.calculator.service;

import com.shs.exercise.calculator.data.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Service
public class CalculatorService {

    @Autowired
    CalculatorActions calculatorActions;

    public static String NO_METHOD_EXCEPTION_MESSAGE = "operator '%s' is not supported." +
            "%nSupported operations are: plus, minus, multiply and divide";

    public static String CALCULATOR_FAILED_MESSAGE = "Calculator failed";

    public String calculate(Calculator calculator) {
        Method method;
        try {
            method = CalculatorActions.class.getDeclaredMethod(calculator.getOperator(), int.class, int.class);
        } catch (NoSuchMethodException noSuchMethodException) {
            return String.format(NO_METHOD_EXCEPTION_MESSAGE, calculator.getOperator());
        }
        try {
            return (String) method.invoke(calculatorActions, calculator.getLeft(), calculator.getRight());
        } catch (IllegalAccessException | InvocationTargetException exception) {
            return CALCULATOR_FAILED_MESSAGE;
        }
    }
}

