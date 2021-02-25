package com.shs.exercise.calculator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CalculatorActionsTest {

    @Autowired
    CalculatorActions calculatorActions;

    @Test
    public void plus_test() {
        String result = calculatorActions.plus(1, 2);
        assertThat(result, equalTo("1 + 2 = 3"));
    }

    @Test
    public void minus_test() {
        String result = calculatorActions.minus(1, 2);
        assertThat(result, equalTo("1 - 2 = -1"));
    }

    @Test
    public void multiply_test() {
        String result = calculatorActions.multiply(1, 2);
        assertThat(result, equalTo("1 * 2 = 2"));
    }

    @Test
    public void divide_test() {
        String result = calculatorActions.divide(1, 2);
        assertThat(result, equalTo("1 / 2 = 0"));
    }

    @Test
    public void divide_in_zero_test() {
        String result = calculatorActions.divide(1, 0);
        assertThat(result, equalTo(calculatorActions.DIVIDE_ERROR_MESSAGE));
    }

}
