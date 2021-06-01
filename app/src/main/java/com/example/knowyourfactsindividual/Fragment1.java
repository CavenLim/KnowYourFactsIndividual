package com.example.knowyourfactsindividual;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;


public class Fragment1 extends Fragment {
    Button btnChangeColor ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_1, container, false);

        btnChangeColor = view.findViewById(R.id.btnColorFrag1);
        Random randomColorNo = new Random();


        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
               float r = (float) (randomColorNo.nextFloat() / 2f +0.5);
               float g = (float) (randomColorNo.nextFloat() / 2f +0.5);
               float b = (float) (randomColorNo.nextFloat() / 2f +0.5);
                int rgb = android.graphics.Color.rgb(r, g, b);
               view.setBackgroundColor(rgb);


            }
        });


        return view;
    }
}