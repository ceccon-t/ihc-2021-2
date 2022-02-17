package com.example.atividade1exercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToNext(View view) {
        String message = ((EditText) findViewById(R.id.editTextMessage)).getText().toString();

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message", message);

        startActivity(intent);
    }
}