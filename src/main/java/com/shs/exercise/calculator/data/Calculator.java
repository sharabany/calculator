package com.shs.exercise.calculator.data;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class Calculator {

//    @NonNull
    private Integer left;
//    @NonNull
    private Integer right;

    private String operator;

}
