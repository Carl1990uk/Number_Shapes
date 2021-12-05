package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{
        int number;

        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }
        }
        public boolean isTriangle(){
            int x = 1;
            int triangularNumber = 1;

            while(triangularNumber < number){
                x++;
                triangularNumber = x*(x+1)/2;
            }
            if (triangularNumber == number){
                return true;
            }else{
                return false;
            }
        }

    }
    public void testNumber(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        Number myNumber = new Number();
        myNumber.number = Integer.parseInt(editText.getText().toString());
        String message;
        if(myNumber.isSquare() && myNumber.isTriangle()){
            message = editText.getText().toString() + " is square and triangular";
        }else if(myNumber.isSquare()){
            message = editText.getText().toString() + " is a square number";
        }else if(myNumber.isTriangle()){
            message = editText.getText().toString() + " is a triangular number";
        }else{
            message = editText.getText().toString() + "it is not a square or triangular number";
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}