package com.example.fragmentpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    Button btnFragB , btnFragA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        loadFrag(new BFragment() , 0);
        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrag(new AFragment() , 1);
            }
        });

        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrag(new BFragment() , 1);
            }
        });


    }

    void init()
    {
        btnFragB = findViewById(R.id.btnFragB);
        btnFragA = findViewById(R.id.btnFragA);
    }
    public void loadFrag(Fragment frag , int flag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag ==0)
            ft.add(R.id.container , frag);
        else
            ft.replace(R.id.container , frag);

        ft.commit();
    }

}