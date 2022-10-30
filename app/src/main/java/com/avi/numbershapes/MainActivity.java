package com.avi.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number {
        int number;
        public boolean isTriangular(){
            int x=1;
            int TriangularNumber=1;
            while (TriangularNumber<number){
                x++;
                TriangularNumber=TriangularNumber+x;
            }


            if(TriangularNumber==number){
                return true;
            }
            else {
                return false;
            }
        }
        public boolean isSquare(){
            double squareRoot=Math.sqrt(number);

            if (squareRoot==Math.floor(squareRoot)){
                return true;
            }
            else {
                return false;
            }
        }
    }

    public void testNumber(View view){
        Log.i("info","button pressed");
        EditText editText= (EditText) findViewById(R.id.editTextNumber);
        String message;
        if(editText.getText().toString().isEmpty()){
            message="Please Enter a Value";
        }
        else {
            Number myNum=new Number();
            myNum.number=Integer.parseInt(editText.getText().toString());
            message = editText.getText().toString();

            if (myNum.isSquare() && myNum.isTriangular()) {
                message += " is Both Square And Triangular";
            } else if (myNum.isSquare()) {
                message += " is Square number But Not Triangular";
            } else if (myNum.isTriangular()) {
                message += " is Triangular number but not a square number";
            } else {
                message += " is Neither Triangular Nor Square";
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}