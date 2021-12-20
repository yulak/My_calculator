package com.example.mycalculator;

public class CalculatorLogic {
    //логика состояния калькулятора
    private int firstArg;
    private int secondArg;

    StringBuilder inputStr = new StringBuilder(); //класс для накопления числа, когда нажимаем отдельные кнопки

    private int actionSelected; //переменная для хранения действия пользователя (типо плюс, минус, разделить)

    private State state; //состояние калькулятора в данный момент времени

    private enum State{
        firstArgInput,
        secondArgInput,
        resultShow
    }

    //кнструктор инициализации полей

    public CalculatorLogic() {
        state = State.firstArgInput;
    }

    //метод: реакция на нажатие кноки с цифрой
    public void onNumPressed (int buttonId){

        if (state == State.resultShow){
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() < 9 ){ //ограничение на ввод цифр (не более 10)
            switch (buttonId){
                case R.id.button_0:
                    if (inputStr.length() != 0) { //проверка чтобы цифра не начаналась с нуля
                        inputStr.append("0");
                        break;
                    }
                case R.id.button_1:
                    inputStr.append("1");
                    break;
                case R.id.button_2:
                    inputStr.append("2");
                    break;
                case R.id.button_3:
                    inputStr.append("3");
                    break;
                case R.id.button_4:
                    inputStr.append("4");
                    break;
                case R.id.button_5:
                    inputStr.append("5");
                    break;
                case R.id.button_6:
                    inputStr.append("6");
                    break;
                case R.id.button_7:
                    inputStr.append("7");
                    break;
                case R.id.button_8:
                    inputStr.append("8");
                    break;
                case R.id.button_9:
                    inputStr.append("9");
                    break;
            }
        }

    }

    //метод: реакция на кнопки арифметики
    public void onActionPressed (int actionId){
        if (actionId == R.id.button_equals &&   state == State.secondArgInput){ //обработка кнопки равно (срабатывает если мы находимся на этапе ввода второго аргкмента)
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected){
                case R.id.button_minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.button_plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.button_multiplication:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.button_clear:
                    actionSelected = R.id.button_clear;
                    break;
                case R.id.button_division:
                    inputStr.append(firstArg / secondArg);
                    break;
                case R.id.button_back_space:
                    actionSelected = R.id.button_back_space;
                    break;
                case R.id.button_percent:
                    actionSelected = R.id.button_percent;
                    break;
                case R.id.button_comma:
                    actionSelected = R.id.button_comma;
                    break;
                case R.id.button_equals:
                    actionSelected = R.id.button_equals;
                    break;
            }
        }else if (inputStr.length() > 0 && state == State.firstArgInput){
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
        }
        switch (actionId){
            case R.id.button_minus:
                actionSelected = R.id.button_minus;
                break;
            case R.id.button_plus:
                actionSelected = R.id.button_plus;
                break;
            case R.id.button_multiplication:
                actionSelected = R.id.button_multiplication;
                break;
            case R.id.button_clear:
                actionSelected = R.id.button_clear;
                break;
            case R.id.button_division:
                actionSelected = R.id.button_division;
                break;
            case R.id.button_back_space:
                actionSelected = R.id.button_back_space;
                break;
            case R.id.button_percent:
                actionSelected = R.id.button_percent;
                break;
            case R.id.button_comma:
                actionSelected = R.id.button_comma;
                break;
            case R.id.button_equals:
                actionSelected = R.id.button_equals;
                break;
        }
    }

    //метод, позволяющий получить текст для отображения в текстовом поле
    public String getAnswer(){
        return inputStr.toString();

    }
}
