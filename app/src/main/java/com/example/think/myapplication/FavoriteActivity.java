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
import static com.example.think.myapplication.MainActivity.presentActivity;

/**
 * Created by Think on 2016/12/19.
 */

public class FavoriteActivity extends AppCompatActivity {
    private Button home;
    private Button introduce;
    private Button want;

    protected void onCreate(Bundle savedInstanceState) {
        presentActivity=1;
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.favorite_list);
        home=(Button) findViewById(R.id.rbtn_home);
        introduce=(Button) findViewById(R.id.rbtn_introduce);
        want=(Button) findViewById(R.id.rbtn_want);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoriteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.setShow(3);
                Intent intent = new Intent(FavoriteActivity.this, IntroduceActivity.class);
                startActivity(intent);
            }
        });
        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoriteActivity.this, WantActivity.class);
                startActivity(intent);
            }
        });
        DishlistAdapter adapter=new DishlistAdapter(FavoriteActivity.this,R.layout.dishitem,dishes.getShow());
        ListView listView = (ListView) findViewById(R.id.dish_list);
        listView.setAdapter(adapter);

    }
    protected void onResume(){
        super.onResume();
        presentActivity=1;
    }
}
