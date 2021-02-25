package com.shs.exercise.calculator.data;

import lombok.Data;
import lombok.NonNull;
import lombok.Value;

@Data
public class Calculator {

    @NonNull
    private Integer left;
    @NonNull
    private Integer right;
    @NonNull
    private String operator;

}
