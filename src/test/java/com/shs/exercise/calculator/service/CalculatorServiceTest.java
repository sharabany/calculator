package com.shs.exercise.calculator.service;

import com.shs.exercise.calculator.data.Calculator;
import com.shs.exercise.calculator.interfaceAction.CalculatorActionInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CalculatorServiceTest {

    @InjectMocks
    CalculatorService calculatorService;
    @Mock
    Calculator calculator;
    @Mock
    List<CalculatorActionInterface> calculatorActions;


    @Test
    public void test_when_input_include_unknown_operator_then_return_error() {
        setupCalculator("plusss");
        String result = calculatorService.calculate(calculator);
        assertThat(result, equalTo("operator 'plusss' is not supported.\r\nSupported operations are: plus, minus, multiply and divide"));
    }


    @Test
    public void test_when_find_operator_class_success_then_return_result() {
        setupCalculator("plus");
        String result = calculatorService.calculate(calculator);
        assertThat(result, equalTo("2 + 1 = 3"));
    }

    private void setupCalculator(String op) {
        when(calculator.getOperator()).thenReturn(op);
        when(calculator.getLeft()).thenReturn(2);
        when(calculator.getRight()).thenReturn(1);

        List<CalculatorActionInterface> calculatorActionInterfaces = singletonList(new PlusAction());
        when(calculatorActions.stream()).thenReturn(calculatorActionInterfaces.stream());
    }
}