package com.shs.exercise.calculator.data;

//according to the request specific operators

public enum Operator {

    PLUS("plus"),
    MINUS("minus"),
    MULTIPLY("multiply"),
    DIVIDE("divide");

    private final String value;

    Operator(String operator) {
        value = operator;
    }
}
