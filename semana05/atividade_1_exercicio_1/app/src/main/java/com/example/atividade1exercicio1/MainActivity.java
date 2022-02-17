package com.example.atividade1exercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sum(View view) {
        String firstNumber = ((EditText) findViewById(R.id.editTextFirstNumber)).getText().toString();
        String secondNumber = ((EditText) findViewById(R.id.editTextSecondNumber)).getText().toString();
        TextView resultView = (TextView) findViewById(R.id.textViewResult);

        try {
            Integer result = Integer.valueOf(firstNumber) + Integer.valueOf(secondNumber);
            resultView.setText(result.toString());
        } catch (Exception e) {
            resultView.setText("Make sure that both inputs are integer numbers...");
        }
    }
}