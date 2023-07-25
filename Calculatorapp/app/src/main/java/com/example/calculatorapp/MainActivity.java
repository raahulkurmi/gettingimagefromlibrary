package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn9, btn8, btn7, btn6, btn5, btn4, btn3, btn2, btn1, btn0, btndot, btnclr, btnadd, btneql;
    int num;
    int sum = 0;
    private final String REQ="Add";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btn9 = findViewById(R.id.btn9);
        btn8 = findViewById(R.id.btn8);
        btn7 = findViewById(R.id.btn7);
        btn6 = findViewById(R.id.btn6);
        btn5 = findViewById(R.id.btn5);
        btn4 = findViewById(R.id.btn4);
        btn3 = findViewById(R.id.btn3);
        btn2 = findViewById(R.id.btn2);
        btn1 = findViewById(R.id.btn1);
        btn0 = findViewById(R.id.btn0);
        btndot = findViewById(R.id.btndot);
        btnclr = findViewById(R.id.btncl);
        btnadd = findViewById(R.id.btnadd);
        btneql = findViewById(R.id.btnequal);


        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btn9.getText().toString());


                editText.append("" + num);


            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btn8.getText().toString());


                editText.append("" + num);


            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btn7.getText().toString());


                editText.append("" + num);


            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btn6.getText().toString());


                editText.append("" + num);


            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btn5.getText().toString());


                editText.append("" + num);


            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btn4.getText().toString());


                editText.append("" + num);


            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btn3.getText().toString());


                editText.append("" + num);


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btn2.getText().toString());


                editText.append("" + num);


            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btn1.getText().toString());


                editText.append("" + num);


            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btn0.getText().toString());


                editText.append("" + num);


            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btn9.getText().toString());


                editText.append("" + num);


            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btndot.getText().toString());


                editText.append("" + num);


            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(btnadd.getText().toString());
                editText.append("" +REQ,num);
           

//


            }
        });
        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");

            }
        });
        btneql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(REQ==1){

                }
            }
        });

    }





//    }
//    public void btn8(View v){
//         num=Integer.parseInt( btn8.getText().toString());
//        editText.append(""+num);
//
//
//
//
//    }
//    public void btn7(View v){
//        num=Integer.parseInt( btn7.getText().toString());
//        editText.append(""+num);
//
//
//    }
//    public void btn6(View v){
//        num=Integer.parseInt( btn6.getText().toString());
//        editText.append(""+num);
//
//
//    }
//    public void btn5(View v){
//        num=Integer.parseInt( btn5.getText().toString());
//        editText.append(""+num);
//
//
//    }
//    public void btn4(View v){
//        num=Integer.parseInt( btn4.getText().toString());
//        editText.append(""+num);
//
//
//    }
//    public void btn3(View v){
//        num=Integer.parseInt( btn3.getText().toString());
//        editText.append(""+num);
//
//
//    }
//    public void btn2(View v){
//        num=Integer.parseInt( btn2.getText().toString());
//        editText.append(""+num);
//
//
//
//    }
//    public void btn1(View v){
//        num=Integer.parseInt( btn1.getText().toString());
//        editText.append(""+num);
//
//
//    }
//    public void btn0(View v){
//        num=Integer.parseInt( btn0.getText().toString());
//        editText.append(""+num);
//
//
//    }
//    public void btn(View v){
//        num=Integer.parseInt(btndot.getText().toString());
//        editText.append(""+num);
//
//
//    }
//    public void btnclr(View v){
//
//
//    }
//    public void add(View v){
//       String symbol=btnadd.getText().toString();
//        editText.append(""+symbol);
//        sum=num+num;
//
//
//    }
//
//
//    public void equal(View v){
//        switch (v.getId()){
//            case R.id.btnadd:
//
//                editText.setText(""+sum);
//
//
//
//        }
//    }
//
//
//
//
//
}