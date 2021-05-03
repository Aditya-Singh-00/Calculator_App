package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Evaluate evaluate = new Evaluate();

        TextView textView = findViewById(R.id.textView);
        TextView result = findViewById(R.id.textView2);

        Button btn0 = findViewById(R.id.button0);
        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);
        Button btn6 = findViewById(R.id.button6);
        Button btn7 = findViewById(R.id.button7);
        Button btn8 = findViewById(R.id.button8);
        Button btn9 = findViewById(R.id.button9);
        Button btnpoint = findViewById(R.id.buttonpoint);
        Button btnpercent = findViewById(R.id.buttonpercent);
        Button btnadd = findViewById(R.id.buttonadd);
        Button btnsub = findViewById(R.id.buttonsub);
        Button btndivide = findViewById(R.id.buttondivide);
        Button btnmulitply = findViewById(R.id.buttonmultiply);
        Button btnpower = findViewById(R.id.buttonpow);
        Button btnclear = findViewById(R.id.buttonClear);
        Button btndel = findViewById(R.id.buttondel);
        Button btnequal = findViewById(R.id.buttonequal);

        AtomicBoolean operator = new AtomicBoolean(false);
        AtomicBoolean point = new AtomicBoolean(true);
        AtomicBoolean num = new AtomicBoolean(false);

        btn0.setOnClickListener(v -> {

            textView.append("0");
            operator.set(true);
            result.setText(evaluate.calculateValue(textView.getText().toString()));
            if(textView.getText().toString().contains(".")){
                point.set(false);
            }

        });

        btn1.setOnClickListener(v -> {

            textView.append("1");
            operator.set(true);
            result.setText(evaluate.calculateValue(textView.getText().toString()));
            if(textView.getText().toString().contains(".")){
                point.set(false);
            }

        });

        btn2.setOnClickListener(v -> {
            textView.append("2");
            operator.set(true);
            result.setText(evaluate.calculateValue(textView.getText().toString()));
            if(textView.getText().toString().contains(".")){
                point.set(false);
            }

        });

        btn3.setOnClickListener(v -> {
            textView.append("3");
            operator.set(true);
            result.setText(evaluate.calculateValue(textView.getText().toString()));
            if(textView.getText().toString().contains(".")){
                point.set(false);
            }

        });

        btn4.setOnClickListener(v -> {
            textView.append("4");
            operator.set(true);
            result.setText(evaluate.calculateValue(textView.getText().toString()));
            if(textView.getText().toString().contains(".")){
                point.set(false);
            }

        });

        btn5.setOnClickListener(v -> {
            textView.append("5");
            operator.set(true);
            result.setText(evaluate.calculateValue(textView.getText().toString()));
            if(textView.getText().toString().contains(".")){
                point.set(false);
            }

        });

        btn6.setOnClickListener(v -> {
            textView.append("6");
            operator.set(true);
            result.setText(evaluate.calculateValue(textView.getText().toString()));
            if(textView.getText().toString().contains(".")){
                point.set(false);
            }

        });

        btn7.setOnClickListener(v -> {
            textView.append("7");
            operator.set(true);
            result.setText(evaluate.calculateValue(textView.getText().toString()));
            if(textView.getText().toString().contains(".")){
                point.set(false);
            }

        });

        btn8.setOnClickListener(v -> {
            textView.append("8");
            operator.set(true);
            result.setText(evaluate.calculateValue(textView.getText().toString()));
            if(textView.getText().toString().contains(".")){
                point.set(false);
            }

        });

        btn9.setOnClickListener(v -> {
            textView.append("9");
            operator.set(true);
            result.setText(evaluate.calculateValue(textView.getText().toString()));
            if(textView.getText().toString().contains(".")){
                point.set(false);
            }

        });


        btnpoint.setOnClickListener(v -> {
            String str = textView.getText().toString();
            if(point.get() == true && str.length()>0 && operator.get()==true) {
                textView.append(".");
                operator.set(false);
                point.set(false);


            }
        });

        btnpercent.setOnClickListener(v -> {
            if(operator.get()==true) {
                textView.append("%");
                operator.set(false);
            }

        });

        btnadd.setOnClickListener(v -> {
            if(operator.get()==true) {
                textView.append("+");
                operator.set(false);
            }
        });

        btnsub.setOnClickListener(v -> {
            if(operator.get()==true ||textView.getText().toString().length()==0) {
                textView.append("-");
                operator.set(false);
            }
        });

        btnmulitply.setOnClickListener(v -> {
            if(operator.get()==true) {
                textView.append("*");
                operator.set(false);
            }
        });

        btndivide.setOnClickListener(v -> {
            if(operator.get()==true) {
                textView.append("/");
                operator.set(false);
            }
        });

        btnpercent.setOnClickListener(v -> {
            if(operator.get()==true) {
                textView.append("%");
                operator.set(false);
            }
        });

        btnpower.setOnClickListener(v -> {
            if(operator.get()==true) {
                textView.append("^");
                operator.set(false);
            }
        });

        btndel.setOnClickListener(v -> {
            String str = textView.getText().toString();
            if(str.length() == 0 ) {
                result.setText("");
            }
            else {
                if(str.charAt(str.length()-1) == '.') {
                    point.set(true);
                }
                textView.setText(textView.getText().toString().substring(0,str.length()-1)+"");

            }
            str = textView.getText().toString();
            if(str.length() == 0 ){
                operator.set(false);
                point.set(true);
            }
            else{
                if(str.charAt(str.length()-1) >= '0' && str.charAt(str.length()-1) <= '9' ){
                    operator.set(true);
                    result.setText(evaluate.calculateValue(textView.getText().toString()));
                }
                else
                    operator.set(false);
            }

        });

        btnclear.setOnClickListener(v -> {
            textView.setText("");
            result.setText("");
            operator.set(false);
            point.set(true);
        });

        btnequal.setOnClickListener(v -> {
            if(operator.get() == true) {
                textView.setText(evaluate.calculateValue(textView.getText().toString()));
                if (textView.getText().toString().contains(".")) {
                    point.set(false);
                }
            }
        });

    }

}