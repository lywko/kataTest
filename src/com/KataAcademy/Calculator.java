package com.KataAcademy;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    //переменные выражения и оператор
    private int num1, num2;
    private String operator;

    //определение операции
    private int calc(int n1, String op, int n2){
        int res;
        switch (op) {
            case "+":
                res = n1+n2;
                break;
            case "-":
                res = n1-n2;
                break;
            case "*":
                res = n1*n2;
                break;
            case "/":
                res = n1/n2;
                break;
            default:
                throw new IllegalStateException("ОШИБКА. Неверный оператор: " + op +". Доступны только: +, -, *, / ");
        }
        return res;
    }

    public String result (String expr) throws CalculatorException{
        boolean isRoman;
        Convertor convertor = new Convertor();

        //разбиение выражения на элементы массива
        List<String> exprItems = Arrays.asList(expr.split(" "));
        operator = exprItems.get(1);

        if (exprItems.size()!=3){
            throw new CalculatorException("ОШИБКА. В выражении допустим только вид : \"Операнда1, операция, операнда2\".");
        }

        //проверка, что обе операнды либо римские, либо арабские
        if(convertor.isRoman(exprItems.get(0)) && convertor.isRoman(exprItems.get(2))){
            num1 = convertor.romeToArab(exprItems.get(0));
            num2 = convertor.romeToArab(exprItems.get(2));
            isRoman = true;
        } else if (convertor.isArab(exprItems.get(0)) && convertor.isArab(exprItems.get(2))){
            num1 = Integer.parseInt(exprItems.get(0));
            num2 = Integer.parseInt(exprItems.get(2));
            isRoman = false;
        } else {
            throw new CalculatorException("ОШИБКА. Обе перанды должны быть либо только арабскими, либо только римскими.");
        }


        if(num1 < 1 || num1 > 10){
            throw new CalculatorException("ОШИБКА. Операнды не должны быть меньше 1(I) или больше 10(X)");
        }
        if(num2 < 1 || num2 > 10){
            throw new CalculatorException("ОШИБКА. Операнды не должны быть меньше 1(I) или больше 10(X)");
        }

        int res = calc(num1, operator, num2);



        //конвертация в арабские для результата в римских
        if (isRoman && res > 1){
            return convertor.arabToRome(Math.abs(res));
        } else if (isRoman && res < 1){
            throw new CalculatorException("ОШИБКА. В римском исчислении не предусмотрены цифры ниже единицы.");
        }

        return String.valueOf(res);
    }


}
