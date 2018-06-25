package com.example.krixz.mytimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


public class chasestopwatch extends AppCompatActivity
{

    private int milliseconds=0;
    private boolean running=true;
    private boolean wasrunning;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chasestopwatch);

        Intent I=getIntent();

        milliseconds=I.getIntExtra("passed",0);


        process();


    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("value",milliseconds);
        savedInstanceState.putBoolean("status",running);
        savedInstanceState.putBoolean("oldstatus",wasrunning);
    }

    @Override
    public void onStop()
    {
        super.onStop();
        wasrunning=running;
        running=false;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        if(wasrunning==true)
            running=true;
    }


    public void RESUME(View view)
    {
        running=true;
    }

    public void PAUSE(View view)
    {
        running=false;
    }

    public void process()
    {
        final TextView TV=(TextView)(findViewById(R.id.timerem));

        final Handler H= new Handler();


        H.post(new Runnable() {

            @Override

            public void run()
            {
                int milli=milliseconds%100;
                int sec=(milliseconds/100)%60;
                int min=(milliseconds/100)/60;
                int hrs=(milliseconds/100)/3600;


                String TIME=String.format("%d:%02d:%02d:%02d",hrs,min,sec,milli);


                TV.setText(TIME);

                if(running)
                {
                    milliseconds--;
                }

                if(milliseconds==0)
                    running=false;

                H.postDelayed(this,10);
            }




        });


    }

}
