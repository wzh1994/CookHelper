package com.example.think.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.example.think.myapplication.adapter.StageAdapter;

import static com.example.think.myapplication.MainActivity.dishes;

/**
 * Created by Think on 2016/12/20.
 */

public class DoItNowActivity extends AppCompatActivity {
    private Button home;
    private Button introduce;
    private Button favorite;
    private Button want;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.doitnow);

        home=(Button) findViewById(R.id.rbtn_home);
        favorite=(Button) findViewById(R.id.rbtn_love);
        introduce=(Button) findViewById(R.id.rbtn_introduce);
        want=(Button) findViewById(R.id.rbtn_want);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoItNowActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.setShow(2);
                Intent intent = new Intent(DoItNowActivity.this, FavoriteActivity.class);
                startActivity(intent);
            }
        });
        introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.setShow(3);
                Intent intent = new Intent(DoItNowActivity.this, IntroduceActivity.class);
                startActivity(intent);
            }
        });
        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoItNowActivity.this, WantActivity.class);
                startActivity(intent);
            }
        });
        StageAdapter adapter=new StageAdapter(DoItNowActivity.this,R.layout.stage_item,dishes.getAllProcesses());
        ListView listView = (ListView) findViewById(R.id.stage_list);
        listView.setAdapter(adapter);

    }
}
