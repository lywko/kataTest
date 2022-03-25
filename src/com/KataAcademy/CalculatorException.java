package com.KataAcademy;

public class CalculatorException extends Exception{

    public CalculatorException(){
        System.out.println("Выражение не соответсвует требованиям.");
    }

    public CalculatorException(String message){
        this();
        System.out.println(message);
    }
}
