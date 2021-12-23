package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CalculatorLogic calculator;
    private TextView answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numberIds = new int[]{
                R.id.button_0,
                R.id.button_1,
                R.id.button_2,
                R.id.button_3,
                R.id.button_4,
                R.id.button_5,
                R.id.button_6,
                R.id.button_7,
                R.id.button_8,
                R.id.button_9,
        };

        int[] actonIds = new int[]{
                R.id.button_minus,
                R.id.button_plus,
                R.id.button_multiplication,
                R.id.button_clear,
                R.id.button_division,
                R.id.button_back_space,
                R.id.button_percent,
                R.id.button_comma,
                R.id.button_equals,
        };

        //получение данных из калькулятора
        answer = findViewById(R.id.answer);

        calculator = new CalculatorLogic();

        //обработчик событий для кнопок (цифры)
        View.OnClickListener numberButtonsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                answer.setText(calculator.getAnswer());
            }
        };
        //обработчик событий для кнопок (знаки)
        View.OnClickListener actionButtonsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                answer.setText(calculator.getAnswer());
            }
        };

        //(передача событий внутрь калькулятора) здесь прошлись по массивам кнопок и установили обработчик кнопок, который будет вызываться при нажатии
        for (int i = 0; i < numberIds.length; i++) {
            findViewById(numberIds[i]).setOnClickListener(numberButtonsClickListener);
        }

        for (int i = 0; i < actonIds.length; i++) {
            findViewById(actonIds[i]).setOnClickListener(actionButtonsClickListener);
        }

    }
}