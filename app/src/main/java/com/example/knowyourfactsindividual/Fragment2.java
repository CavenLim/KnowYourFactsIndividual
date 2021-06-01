package com.example.knowyourfactsindividual;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.Random;


public class Fragment2 extends Fragment {
    Button btnChangeColor;
    ImageView iv,iv2,iv3;
    LinearLayout ll;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_2, container, false);
        iv=view.findViewById(R.id.iv);
        iv2=view.findViewById(R.id.iv2);
        iv3=view.findViewById(R.id.iv3);
        btnChangeColor = view.findViewById(R.id.btnColorFrag2);
        ll = view.findViewById(R.id.layoutfor2);

        String imageUrl = "https://wtffunfact.com/wp-content/uploads/2021/05/WTF-Fun-Fact-Crassuss-Fire-Brigade-1.png";
        String imageUrl2 = "https://wtffunfact.com/wp-content/uploads/2021/05/WTF-Fun-Fact-Arctic-Foxs-Colorful-Fur.png";
        String imageUrl3 = "https://wtffunfact.com/wp-content/uploads/2021/05/WTF-Fun-Fact-From-NFL-To-Serial-Killer.png";
        Picasso.with(getActivity()).load(imageUrl).into(iv);
        Picasso.with(getActivity()).load(imageUrl2).into(iv2);
        Picasso.with(getActivity()).load(imageUrl3).into(iv3);
        Random randomColorNo = new Random();
        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("Button","Button Pressed");
                float r = (float) (randomColorNo.nextFloat() / 2f +0.5);
                float g = (float) (randomColorNo.nextFloat() / 2f +0.5);
                float b = (float) (randomColorNo.nextFloat() / 2f +0.5);
                int rgb = android.graphics.Color.rgb(r, g, b);
                ll.setBackgroundColor(rgb);
            }
        });

        return view;
    }
}