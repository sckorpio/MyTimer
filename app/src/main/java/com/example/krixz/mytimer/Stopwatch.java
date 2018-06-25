package com.example.krixz.mytimer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.TextView;

public class Stopwatch extends AppCompatActivity
{
    private int milliseconds=0;
    private boolean running=false;
    private boolean wasrunning;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        if(savedInstanceState!=null)
        {
            milliseconds=savedInstanceState.getInt("value");
            running=savedInstanceState.getBoolean("status");
            wasrunning=savedInstanceState.getBoolean("oldrunning");
        }

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


    public void START(View view)
    {
        running=true;
    }

    public void STOP(View view)
    {
        running=false;
    }

    public void RESET(View view)
    {
        running=false;
        milliseconds=0;
    }


    public void process()
    {
        final TextView TV=(TextView)(findViewById(R.id.timeview));

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
                    milliseconds++;
                }

                H.postDelayed(this,10);
            }




        });


    }



}

