package com.example.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class Evaluate {

    public String calculateValue(String str) {
        String exp = postfix(str);
        return value(exp);
    }
    private String value(String exp) {
        Stack<String> stack = new Stack<>();


        for(int i = 0;i<exp.length();i++) {
            char c = exp.charAt(i);
            if( c == ' ')
                continue;
            else if(Character.isDigit(c)) {

                double n = 0;
                boolean pointSeen = false;
                while(Character.isDigit(c) || c == '.') {
                    if(c == '.') {
                        pointSeen = true;
                        i++;
                        c = exp.charAt(i);
                        break;

                    }
                    n = n*10 + (int)(c - '0');
                    i++;
                    c = exp.charAt(i);
                }

                if(pointSeen) {
                    int p = -1;
                    while(Character.isDigit(c)) {

                        n += (c -'0')*Math.pow(10, p--);

                        i++;
                        c = exp.charAt(i);
                    }
                }
                i--;
                stack.push(String.valueOf(n));
            }
            else {
                BigDecimal val1 = new BigDecimal(stack.pop());
                BigDecimal val2 = new BigDecimal(stack.pop());
                System.out.println(val1 + " " + val2);
                switch (c) {
                    case '+':
                        stack.push(String.valueOf(val2.add(val1)));
                        break;
                    case '-':
                        stack.push(String.valueOf(val2.subtract(val1)));
                        break;
                    case '*':
                        stack.push(String.valueOf(val2.multiply(val1)));
                        break;
                    case '/':
                        try {
                            stack.push(String.valueOf(val2.divide(val1)));
                        }catch(ArithmeticException e) {
                            stack.push(String.valueOf(val2.divide(val1,10, RoundingMode.HALF_EVEN)));
                        }
                        break;
                    case '%':
                        stack.push(String.valueOf(val2.multiply(val1).divide(new BigDecimal(100))));
                        break;
                    case '^':
                        stack.push(String.valueOf(Math.pow(val2.doubleValue(),val1.doubleValue())));
                        break;
                }
            }
        }
        return stack.pop();
    }

    private String postfix(String str) {
        String result = new String("");
        if(str.charAt(0) == '-'){
            str = "0 "+str;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < str.length(); i++ ) {
            char c = str.charAt(i);
            if(Character.isDigit(c)) {
                while( Character.isDigit(c) || c == '.') {
                    result+=c;
                    i++;
                    if(i == str.length()) break;
                    c = str.charAt(i);

                }
                i--;
                result+=" ";
            }
            else {
                while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    result += stack.pop() + " ";
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            result+=stack.pop() + " ";
        }

        System.out.println(result);

        return result;
    }

    private int Prec(char c) {
        switch(c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '%':
                return 3;
            case '^':
                return 4;
        }
        return -1;
    }

}
