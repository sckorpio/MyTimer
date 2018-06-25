package com.example.krixz.mytimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;



public class Timechase extends AppCompatActivity
{
    int seconds;
    int min,sec;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timechase);
    }


    public void Chase(View view)
    {
        EditText EM=(EditText)findViewById(R.id.editmin);
        min=Integer.parseInt(EM.getText().toString());

        EditText ES=(EditText)findViewById(R.id.editsec);
        sec=Integer.parseInt(ES.getText().toString());

        seconds=min*60+sec;

        Intent I=new Intent(this,chasestopwatch.class);

        I.putExtra("passed",(seconds*100));

        startActivity(I);



    }
}
