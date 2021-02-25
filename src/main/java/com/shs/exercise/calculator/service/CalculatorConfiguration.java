package com.shs.exercise.calculator.service;

import com.shs.exercise.calculator.data.Operator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.shs.exercise.calculator.data.Operator.*;

@Configuration
public class CalculatorConfiguration {


    @Bean
    public Map<Operator, Runnable> operationsMap(CalculatorService calculatorService) {

        Map<Operator, Runnable> calculatorMap = new HashMap<>();
        calculatorMap.put(PLUS, calculatorService::plus);
        calculatorMap.put(MINUS, calculatorService::minus);
        calculatorMap.put(MULTIPLY, calculatorService::multiply);
        calculatorMap.put(DIVIDE, calculatorService::divide);

        return calculatorMap;
    }
}
