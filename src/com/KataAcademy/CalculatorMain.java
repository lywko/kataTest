package com.KataAcademy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorMain {

    public static void main(String[] args) {
        System.out.println("Калькулятор, вида: \"Операнда1, операция, операнда2\"  принимающий арабские числа от 1 до 10 включительно ИЛИ римские от I до X включительно. Операции: +, -, *, /.");
        System.out.print("Введите выражение: ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String calcStr = reader.readLine();

            Calculator calculator = new Calculator();
            String result = calculator.result(calcStr);
            System.out.println("Ответ: " + result);

        } catch (IOException | CalculatorException e){

        }
    }
}
