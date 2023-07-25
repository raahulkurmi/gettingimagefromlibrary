package com.example.layoutdesign;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating class variable for the class editview
        EditText edtwt,edtft,edtin;

        //creating class variable for the class textview and finding its id

      TextView result,BMI;


       Button button;


        // creating variable for the class constraintlayout
        ConstraintLayout cmain;


        //finding each class with the help of the id
        cmain=findViewById(R.id.cmain);
       edtwt=findViewById(R.id.editText);
       edtft=findViewById(R.id.editText2);
       edtin=findViewById(R.id.editText3);
       result=findViewById(R.id.result);
       BMI=findViewById(R.id.BMI);
       button=findViewById(R.id.button);


        //setting onclick listner on the button

       button.setOnClickListener(view -> {
           //making toast after being clicked o the button
                   Toast.makeText(this,"cliked",Toast.LENGTH_LONG).show();


           //taking data and converting it to integer using parse int function
         int wt= Integer.parseInt(edtwt.getText().toString()) ;
        int ft=Integer.parseInt(edtft.getText().toString()) ;
        int in=Integer.parseInt(edtin.getText().toString());
        //apply mathematical formula for the calculation oof bmi
        int totalin=ft*12+in;
        double totalcm=totalin*2.53;
        double totalm = totalcm/100;
        double bmi=wt/(totalm*totalm);

        //using if else to show result acording to the output
        if(bmi>25){
            //overweight color changed to gray

            //setting background color as per the output generated
            cmain.setBackgroundColor(getResources().getColor(R.color.overweight));
            //setting the textview according to the output
            BMI.setText(""+bmi);
            result.setText("You are overweight");



        } else if (bmi<18) {
            //overweight color changed to red
            //setting background color as per the output generated
            cmain.setBackgroundColor(getResources().getColor(R.color.Healthy));

            //setting the textview according to the output
            BMI.setText(""+bmi);
            result.setText("You are underweight");

        }
        else {
            //healthyweight color changed to green
            //setting background color as per the output generated
            cmain.setBackgroundColor(getResources().getColor(R.color.Underweight));

            //setting the textview according to the output
            result.setText("you are healthy");
            BMI.setText(""+bmi);
        }


       }
       );


    }
}