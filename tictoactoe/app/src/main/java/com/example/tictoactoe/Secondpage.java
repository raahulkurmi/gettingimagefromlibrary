package com.example.tictoactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class Secondpage extends AppCompatActivity {
    Button btn,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    int flag=0;
    int count=0;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Myapp");
        init();


    }
    private void init(){
        btn=findViewById(R.id.btn);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

    }
    public void check(View v){
        Button currentbtn=(Button) v;
        count++;
        if(flag==0){
            currentbtn.setText("x");
            flag=1;

        }
        else {
            currentbtn.setText("0");
            flag=0;
        }
        if(count>4){
            b1=btn.getText().toString();
            b2=btn2.getText().toString();
            b3=btn3.getText().toString();
            b4=btn4.getText().toString();
            b5=btn5.getText().toString();
            b6=btn6.getText().toString();
            b7=btn7.getText().toString();
            b8=btn8.getText().toString();
            b9=btn9.getText().toString();


            if(b1.equals(b2)&& b2.equals(b3) && !b1.equals("")){
                Toast.makeText(this,"Winner" +b1, Toast.LENGTH_SHORT).show();

            }
            else if (b4.equals(b5) && b5.equals(b6) && !b4.equals(" ")){
                Toast.makeText(this,"Winner" +b4, Toast.LENGTH_SHORT).show();

            }
            else if (b7.equals(b8) && b8.equals(b9) && !b7.equals(" ")){
                Toast.makeText(this,"Winner" +b7, Toast.LENGTH_SHORT).show();


            }
            else if (b1.equals(b4) && b4.equals(b7) && !b1.equals(" ")){
                Toast.makeText(this,"Winner" +b1, Toast.LENGTH_SHORT).show();


            }
            else if (b2.equals(b5) && b5.equals(b8) && !b2.equals(" ")){
                Toast.makeText(this,"Winner" +b2, Toast.LENGTH_SHORT).show();


            }
            else if (b3.equals(b6) && b6.equals(b9) && !b3.equals(" ")){
                Toast.makeText(this,"Winner" +b3, Toast.LENGTH_SHORT).show();


            }
            else if (b1.equals(b5) && b5.equals(b9) && !b1.equals(" ")){
                Toast.makeText(this,"Winner" +b1, Toast.LENGTH_SHORT).show();


            }
            else if (b3.equals(b5) && b5.equals(b7) && !b3.equals(" ")){
                Toast.makeText(this,"Winner" +b3, Toast.LENGTH_SHORT).show();


            }

        }


    }
}