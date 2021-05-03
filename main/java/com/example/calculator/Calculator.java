package com.example.calculator;

import java.math.BigDecimal;

public class Calculator {
    private String exp = "";
    private BigDecimal result;

    public void setExp (String str) {
        exp+=str;
    }
    public String getExp() {
        return exp;
    }

}
