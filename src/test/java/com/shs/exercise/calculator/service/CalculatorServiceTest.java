package com.shs.exercise.calculator.service;

import com.shs.exercise.calculator.data.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CalculatorServiceTest {

    @InjectMocks
    CalculatorService calculatorService;
    @Mock
    CalculatorActions calculatorActions;
    @Mock
    Calculator calculator;

    @Test
    public void test_when_input_include_unknown_operator_then_return_error() {
        setupCalculator("plusss");
        String result = calculatorService.calculate(calculator);
        assertThat(result, equalTo("operator 'plusss' is not supported.\r\nSupported operations are: plus, minus, multiply and divide"));
    }

    @Test
    public void test_when_invoke_method_failed_then_return_error() {
        setupCalculator("plus");
        String result = calculatorService.calculate(calculator);
        assertThat(result, nullValue());
    }

    @Test
    public void test_when_invoke_method_success_then_return_result() {
        setupCalculator("plus");
        when(calculatorActions.plus(2, 1)).thenReturn("2 + 1 = 3");
        String result = calculatorService.calculate(calculator);
        assertThat(result, equalTo("2 + 1 = 3"));
    }

    private void setupCalculator(String op) {
        when(calculator.getOperator()).thenReturn(op);
        when(calculator.getLeft()).thenReturn(2);
        when(calculator.getRight()).thenReturn(1);

    }
}