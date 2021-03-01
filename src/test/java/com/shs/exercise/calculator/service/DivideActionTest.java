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
public class DivideActionTest {

    @Autowired
    DivideAction divideAction;

    @Test
    public void test_actionName(){
        assertThat(divideAction.actionName(), equalTo("divide"));
    }

    @Test
    public void test_action(){
        assertThat(divideAction.action(1,2), equalTo("1 / 2 = 0"));
    }
}
