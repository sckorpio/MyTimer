package com.example.krixz.mytimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AdapterView.OnItemClickListener ICL= new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l)
            {
                if(pos==0)
                {
                    Intent I=new Intent(MainActivity.this,Stopwatch.class);
                    startActivity(I);
                }

                else if(pos==1)
                {
                    Intent I=new Intent(MainActivity.this,Lapcounter.class);
                    startActivity(I);
                }

                else if(pos==2)
                {
                    Intent I=new Intent(MainActivity.this,Timechase.class);
                    startActivity(I);
                }

                else if(pos==3)
                {
                    Intent I=new Intent(MainActivity.this,Help.class);
                    startActivity(I);
                }

                else if(pos==4)
                {
                    Intent I=new Intent(MainActivity.this,Credits.class);
                    startActivity(I);
                }


            }
        };


        ListView LV= (ListView)findViewById(R.id.menu);
        LV.setOnItemClickListener(ICL);
    }



}
