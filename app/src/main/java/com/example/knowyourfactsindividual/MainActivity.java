package com.example.knowyourfactsindividual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

import javax.crypto.spec.PSource;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fragment> al;
    PSFragmentPagerAdapter adapter;
    ViewPager vPager;
    Button btnCloseActivity;
    private SharedPreferences savedIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager=findViewById(R.id.viewpager);
        btnCloseActivity=findViewById(R.id.buttonLater);

        FragmentManager fm = getSupportFragmentManager();
        al = new ArrayList<Fragment>();
        al.add(new Fragment1());
        al.add(new Fragment2());
        al.add(new Fragment3());

        adapter = new PSFragmentPagerAdapter(fm,al);

        vPager.setAdapter(adapter);

        btnCloseActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        Random randomPageNo = new Random();
        int id  = item.getItemId();
        if (id == R.id.action_next){
            int max = vPager.getChildCount();
            if (vPager.getCurrentItem() < max-1){
                vPager.setCurrentItem(vPager.getCurrentItem()+1,true);
            }
        }
        else if (id == R.id.action_previous){
            if(vPager.getCurrentItem() > 0 ){
                int previousPage = vPager.getCurrentItem()-1;
                vPager.setCurrentItem(previousPage,true);
            }

        }
        else if (id == R.id.action_random){
            int randomPage = randomPageNo.nextInt(vPager.getChildCount());
            System.out.println(randomPage);
            vPager.setCurrentItem(randomPage,true);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = savedIndex.edit();
        editor.putInt("savedIndex",vPager.getCurrentItem());
        editor.commit();
                super.onPause();
    }

    @Override
    protected void onResume() {
        savedIndex = getSharedPreferences("savedIndex",MODE_PRIVATE);
        vPager.setCurrentItem(savedIndex.getInt("savedIndex",0));
        super.onResume();
    }
}