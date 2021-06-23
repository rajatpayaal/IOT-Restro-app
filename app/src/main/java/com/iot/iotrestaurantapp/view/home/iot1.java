/*-----------------------------------------------------------------------------
 -                                                                            -
 -                                                                            -
 -                                                                            -
 -  * All Rights Reserved                                                     -
 - RAJAT PAYAL                                                                -
 -                                                                            -
 -                                                                            -
 -                                                                            -
 -----------------------------------------------------------------------------*/
package com.iot.iotrestaurantapp.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.iot.iotrestaurantapp.R;

public class iot1 extends AppCompatActivity {
   Button ac;
    Button lamp;
    Button song;
    Button tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iot1);
        ac = findViewById(R.id.ac1);
        tv=findViewById(R.id.tv1);
        lamp=findViewById(R.id.lamp1);
        song=findViewById(R.id.song1);

        ac.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(),control.class));
        });
        tv.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(),control.class));
        });
        lamp.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(),control.class));
        });


        song.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(),control.class));
        });



    }
}