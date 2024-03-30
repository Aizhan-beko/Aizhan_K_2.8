package com.geeks.aizhan_kanybekova_hw_27_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView resultTV;
    Integer firstNumber, secondNumber;

    Boolean isOperation;

    public int operationId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV = findViewById(R.id.resultTv);

        resultTV = findViewById(R.id.resultTv);
        isOperation = false;

    }


    public void numberClick(View view) {
        if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (isOperation) {
                resultTV.setText("");
            }
            resultTV.append(text);

        }
        isOperation = false;
    }

    public void operationClick(View view) {
        String text = resultTV.getText().toString();
        if (view.getId() == R.id.clearBtn) {
            resultTV.setText("");
            firstNumber = null;
            isOperation = false;
        } else if (view.getId() == R.id.plusBtn || view.getId() == R.id.minusBtn ||
                view.getId() == R.id.multiplyBtn || view.getId() == R.id.divideBtn) {
            if (firstNumber == null) {
                firstNumber = Integer.valueOf(resultTV.getText().toString());;
            } else {
                secondNumber = Integer.valueOf(resultTV.getText().toString());
                if (isOperation) {
                    calculateResult(view.getId());
                }
            }
            isOperation = true;
        } else if (view.getId() == R.id.equalBtn) {
            if (firstNumber != null && isOperation) {
                secondNumber = Integer.valueOf(resultTV.getText().toString());;
                calculateResult(R.id.equalBtn);
                isOperation = false;
            }
        }
    }

    private void calculateResult(int operationId) {
        Integer result = 0;
        if (operationId == R.id.plusBtn) {
            result = firstNumber + secondNumber;
        } else if (operationId == R.id.minusBtn) {
            result = firstNumber - secondNumber;
        } else if (operationId == R.id.multiplyBtn) {
            result = firstNumber * secondNumber;
        } else if (operationId == R.id.divideBtn) {
            if (secondNumber != 0) {
                result = firstNumber / secondNumber;
            } else {
                resultTV.setText("Error: Division by zero.");
                return;
            }
        } else if (operationId == R.id.equalBtn) {

        }
        resultTV.setText(String.valueOf(result));
    }

}