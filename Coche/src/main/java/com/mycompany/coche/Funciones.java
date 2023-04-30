/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coche;

public class Funciones {

    public class Temperatura {

        public static double fahrenheitToCelsius(double fahrenheit) {
            return (fahrenheit - 32) * 5 / 9;
        }

        public static double celsiusToFahrenheit(double celsius) {
            return celsius * 9 / 5 + 32;
        }
    }

    public class Numeros {

        public static int romanToDec(String roman) {
            int decimal = 0;
            int lastValue = 0;
            for (int i = roman.length() - 1; i >= 0; i--) {
                char ch = roman.charAt(i);
                int currentValue = getRomanValue(ch);
                if (currentValue < lastValue) {
                    decimal -= currentValue;
                } else {
                    decimal += currentValue;
                }
                lastValue = currentValue;
            }
            return decimal;
        }

        public static String decToRoman(int decimal) {
            if (decimal < 1 || decimal > 3999) {
                throw new IllegalArgumentException("El número debe estar entre 1 y 3999");
            }
            StringBuilder roman = new StringBuilder();
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            for (int i = 0; i < values.length; i++) {
                while (decimal >= values[i]) {
                    decimal -= values[i];
                    roman.append(symbols[i]);
                }
            }
            return roman.toString();
        }

        private static int getRomanValue(char ch) {
            switch (ch) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    throw new IllegalArgumentException("Caracter romano inválido: " + ch);
            }
        }
    }

    public class Conversor {

        public static double dollarToEuro(double dollar) {
            return dollar * 0.84;
        }

        public static double euroToDollar(double euro) {
            return euro * 1.19;
        }
    }

}
