package com.example.think.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.think.myapplication.adapter.DishlistAdapter;
import com.example.think.myapplication.structure.Dish;

import java.util.List;

import static com.example.think.myapplication.MainActivity.dishes;
import static com.example.think.myapplication.MainActivity.presentActivity;

/**
 * Created by Think on 2016/12/19.
 */

public class WantActivity extends AppCompatActivity {
    private Button home;
    private Button introduce;
    private Button favorite;
    private TextView wantInfo;
    private Button dotAllNow;

    protected void onCreate(Bundle savedInstanceState) {
        presentActivity=4;
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.want_list);
        home=(Button) findViewById(R.id.rbtn_home);
        introduce=(Button) findViewById(R.id.rbtn_introduce);
        favorite=(Button) findViewById(R.id.rbtn_love);
        wantInfo=(TextView) findViewById(R.id.want_info);
        dotAllNow=(Button) findViewById(R.id.dotAllNow);

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
        List<Dish> allwant=dishes.getWant();
        int energy=0;
        int cost=0;
        for (int i=0;i<allwant.size();i++){
            energy+=allwant.get(i).getEnergy();
            cost+=allwant.get(i).getPrice();
        }
        wantInfo.setText(" 热量："+energy+"Kcal，成本￥"+cost);
        DishlistAdapter adapter=new DishlistAdapter(WantActivity.this,R.layout.dishitem,allwant);
        ListView listView = (ListView) findViewById(R.id.dish_list);
        listView.setAdapter(adapter);
        dotAllNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WantActivity.this, IntroduceActivity.class);
                startActivity(intent);
            }
        });

    }
    protected void onResume(){
        super.onResume();
        presentActivity=4;
    }
}
