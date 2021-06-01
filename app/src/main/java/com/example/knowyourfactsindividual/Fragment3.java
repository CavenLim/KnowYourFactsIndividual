package com.example.knowyourfactsindividual;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.List;
import java.util.Random;

public class Fragment3 extends Fragment implements RssReader.RssCallback {
    Button btnChangeColor;
    TextView tvRSS;
    private RssReader rssReader = new RssReader(this);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        rssReader.loadFeeds("https://www.singstat.gov.sg/rss");
        btnChangeColor = view.findViewById(R.id.btnColorFrag3);
        tvRSS = view.findViewById(R.id.textViewRss);
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


    @Override
    public void rssFeedsLoaded(List<RSS> rssList) {
        Random rand = new Random();
        int number = rand.nextInt(rssList.get(0).getChannel().getItems().size());
        String title = rssList.get(0).getChannel().getItems().get(number).getTitle();
        String desc = rssList.get(0).getChannel().getItems().get(number).getDescription();
        String link = rssList.get(0).getChannel().getItems().get(number).getLink();
        tvRSS = getActivity().findViewById(R.id.textViewRss);
        tvRSS.setText("Title: "+title+"\n\n"+"Description: "+desc+"\n\n"+"Link: "+link+"\n\n");
    }

    @Override
    public void unableToReadRssFeeds(String errorMessage) {

    }
}