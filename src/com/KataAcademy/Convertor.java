package com.KataAcademy;

import java.util.HashMap;
import java.util.Map;

public class Convertor {
    //соответствие римские-арабские числа (I..X, 1..10)
    private final Map<String, Integer> romeArabMap = new HashMap<>();

    //соответствие римские-арабские наименования чисел
    private final int[] arabDigit = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] romeDigit = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public Convertor() {
        romeArabMap.put("I", 1);
        romeArabMap.put("II", 2);
        romeArabMap.put("III", 3);
        romeArabMap.put("IV", 4);
        romeArabMap.put("V", 5);
        romeArabMap.put("VI", 6);
        romeArabMap.put("VII", 7);
        romeArabMap.put("VIII", 8);
        romeArabMap.put("IX", 9);
        romeArabMap.put("X", 10);
    }

    //проверка на арабское
    public boolean isArab(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //проверка на римское
    public boolean isRoman(String str) {
        return romeArabMap.containsKey(str);
    }

    //из римского в арабское
    public Integer romeToArab(String st){
        if (romeArabMap.containsKey(st)){
            return romeArabMap.get(st);
        }
        return null;
    }

    //из арабского в римское
    public String arabToRome(Integer num){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<arabDigit.length; i++){
            while((num - arabDigit[i])>=0){
                num -= arabDigit[i];
                result.append(romeDigit[i]);
            }
        }
        return result.toString();
    }
}
