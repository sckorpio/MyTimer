package com.example.krixz.mytimer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.TextView;

public class Lapcounter extends AppCompatActivity
{
    private int milliseconds=0;
    private boolean running=false;
    private boolean wasrunning;
    private int lapseconds=0;
    private int laps=0;
     StringBuilder STR= new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapcounter);

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

    public void LAP(View view)
    {

        laps++;

        int milli=lapseconds%100;
        int sec=(lapseconds/100)%60;
        int min=(lapseconds/100)/60;
        int hrs=(lapseconds/100)/3600;


        String TIME=String.format("LAP- %d --> %d:%02d:%02d:%02d",laps,hrs,min,sec,milli);

        STR.append(TIME).append('\n');




        lapseconds=0;
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
        lapseconds=0;
        laps=0;
        STR=new StringBuilder();
    }


    public void process()
    {
        final TextView TV=(TextView)(findViewById(R.id.totaltime));

        final TextView lTV=(TextView)(findViewById(R.id.laptime));

        final TextView LapTV=(TextView)(findViewById(R.id.laptimelist));

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

                 milli=lapseconds%100;
                 sec=(lapseconds/100)%60;
                 min=(lapseconds/100)/60;
                 hrs=(lapseconds/100)/3600;


                String TIMElap=String.format("%d:%02d:%02d:%02d",hrs,min,sec,milli);



                if(running)
                {
                    milliseconds++;
                    lapseconds++;
                }

                TV.setText(TIME);
                lTV.setText(TIMElap);
                LapTV.setText(STR);

                H.postDelayed(this,10);
            }




        });


    }



}
