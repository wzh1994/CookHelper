package com.example.think.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.example.think.myapplication.adapter.DishlistAdapter;

import static com.example.think.myapplication.MainActivity.dishes;

/**
 * Created by Think on 2016/12/19.
 */

public class WantActivity extends AppCompatActivity {
    private Button home;
    private Button introduce;
    private Button favorite;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.want_list);
        home=(Button) findViewById(R.id.rbtn_home);
        introduce=(Button) findViewById(R.id.rbtn_introduce);
        favorite=(Button) findViewById(R.id.rbtn_want);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WantActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.setShow(2);
                Intent intent = new Intent(WantActivity.this, FavoriteActivity.class);
                startActivity(intent);
            }
        });
        introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.setShow(3);
                Intent intent = new Intent(WantActivity.this, IntroduceActivity.class);
                startActivity(intent);
            }
        });
        DishlistAdapter adapter=new DishlistAdapter(WantActivity.this,R.layout.dishitem,dishes.getWant());
        ListView listView = (ListView) findViewById(R.id.dish_list);
        listView.setAdapter(adapter);

    }
}
