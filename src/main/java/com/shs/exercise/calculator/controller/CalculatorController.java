package com.shs.exercise.calculator.controller;

import com.shs.exercise.calculator.data.Calculator;
import com.shs.exercise.calculator.resource.CalculatorResource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CalculatorController {

    @Resource
    private CalculatorResource calculatorResource;

    @PostMapping("/calculate")
    public String calculateNumbersByOperand(@RequestBody @Validated Calculator myCalculator) {
        return calculatorResource.calculate(myCalculator);
    }
}
