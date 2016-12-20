package com.example.think.myapplication;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.think.myapplication.adapter.MaterialAdapter;
import com.example.think.myapplication.adapter.ProcessAdapter;

import static com.example.think.myapplication.MainActivity.dishes;

/**
 * Created by Think on 2016/12/20.
 */

public class DishDetailActivity extends AppCompatActivity  {
    private Button favorite;
    private Button introduce;
    private Button want;
    private Button home;

    private Button dish_islove;
    private Button addToWant;
    private Button doItNow;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dish_detail);
        home=(Button) findViewById(R.id.rbtn_home);
        favorite=(Button) findViewById(R.id.rbtn_love);
        introduce=(Button) findViewById(R.id.rbtn_introduce);
        want=(Button) findViewById(R.id.rbtn_want);
        dish_islove=(Button) findViewById(R.id.dish_islove);
        addToWant=(Button) findViewById(R.id.addToWant);
        doItNow=(Button) findViewById(R.id.doItNow);

        ImageView dishImage = (ImageView)findViewById(R.id.dish_image);
        TextView dishName = (TextView)findViewById(R.id.dish_name);
        TextView dishFeel = (TextView)findViewById(R.id.dish_feel);
        TextView dishMethod = (TextView)findViewById(R.id.dish_method);
        TextView dishTime = (TextView)findViewById(R.id.dish_time);
        TextView dishDiff = (TextView)findViewById(R.id.dish_difficulty);
        TextView dishEnergy = (TextView)findViewById(R.id.dish_energy);
        TextView dishCost = (TextView)findViewById(R.id.dish_cost);

        dishImage.setImageResource(dishes.getPresentDish().getImageId());
        dishName.setText(dishes.getPresentDish().getName());
        dishFeel.setText("    口感："+dishes.getPresentDish().getFeel());
        dishMethod.setText("  烹饪方法："+(dishes.getPresentDish().getType()==1?"炒":".."));
        dishTime.setText("    耗时："+dishes.getPresentDish().getTotalTime());
        dishDiff.setText("  难易："+dishes.getPresentDish().getDifficulty());
        dishEnergy.setText("    热量："+dishes.getPresentDish().getEnergy());
        dishCost.setText("  成本："+dishes.getPresentDish().getPrice());
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DishDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.setShow(2);
                Intent intent = new Intent(DishDetailActivity.this, FavoriteActivity.class);
                startActivity(intent);
            }
        });
        introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.setShow(3);
                Intent intent = new Intent(DishDetailActivity.this, IntroduceActivity.class);
                startActivity(intent);
            }
        });
        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DishDetailActivity.this, WantActivity.class);
                startActivity(intent);
            }
        });

        ProcessAdapter pAdapter=new ProcessAdapter(DishDetailActivity.this,R.layout.processlitem,dishes.getPresentDish().getProcesses());
        ListView plistView = (ListView) findViewById(R.id.process_list);
        plistView.setAdapter(pAdapter);

        MaterialAdapter adapter=new MaterialAdapter(DishDetailActivity.this,R.layout.materialitem,dishes.getPresentDish().getMaterials());
        ListView listView = (ListView) findViewById(R.id.material_list);
        listView.setAdapter(adapter);



        dish_islove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dishes.getPresentDish().isLove()) {
                    dishes.getPresentDish().resetLove();
                    dish_islove.setBackgroundResource(R.drawable.heart);
                }
                else{
                    dishes.getPresentDish().setLove();
                    dish_islove.setBackgroundResource(R.drawable.heart_pad);
                }
            }
        });
        addToWant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.addWant(dishes.getPresentDish().getIndex());
                addToWant.setBackgroundColor(Color.GRAY);
                addToWant.setClickable(false);
            }
        });
        doItNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.setWilldo(dishes.getPresentDish().getIndex());
                Intent intent = new Intent(DishDetailActivity.this, DoItNowActivity.class);
                startActivity(intent);
            }
        });
    }
}
