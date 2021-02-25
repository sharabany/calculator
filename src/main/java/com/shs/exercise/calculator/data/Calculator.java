package com.shs.exercise.calculator.data;

import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class Calculator {

    @NonNull
    private Integer left;
    @NonNull
    private Integer right;
    @NonNull
    private String operator;

}
