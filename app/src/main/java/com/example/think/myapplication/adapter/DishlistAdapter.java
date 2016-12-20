package com.example.think.myapplication.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.think.myapplication.R;
import com.example.think.myapplication.structure.Dish;

import java.util.List;

import static com.example.think.myapplication.MainActivity.dishes;
import static com.example.think.myapplication.MainActivity.presentActivity;

/**
 * Created by Think on 2016/12/19.
 */

public class DishlistAdapter extends ArrayAdapter<Dish> {
    private int resourceId;
    public DishlistAdapter(Context context, int textViewResourceId,
                           List<Dish> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Dish dish = getItem(position); // 获取当前项的Fruit实例
        final View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView dishImage = (ImageView) view.findViewById(R.id.dish_image);
        final ImageView[] dishIsLove = {(ImageView) view.findViewById(R.id.dish_islove)};
        TextView dishName = (TextView) view.findViewById(R.id.dish_name);
        TextView dishMate = (TextView) view.findViewById(R.id.dish_material);
        TextView dishFeel = (TextView) view.findViewById(R.id.dish_feel);
        TextView dishMethod = (TextView) view.findViewById(R.id.dish_method);
        TextView dishTime = (TextView) view.findViewById(R.id.dish_time);
        TextView dishDiff = (TextView) view.findViewById(R.id.dish_difficulty);
        TextView dishEnergy = (TextView) view.findViewById(R.id.dish_energy);
        TextView dishCost = (TextView) view.findViewById(R.id.dish_cost);
        final Button addToWant = (Button)  view.findViewById(R.id.addToWant);
        Button deleteFromWant = (Button)  view.findViewById(R.id.deleteFromWant);
        Button doItNow = (Button)  view.findViewById(R.id.doItNow);
        if (presentActivity<4) {
            addToWant.setVisibility(View.VISIBLE);
            deleteFromWant.setVisibility(View.INVISIBLE);
        }
        else {
            addToWant.setVisibility(View.INVISIBLE);
            deleteFromWant.setVisibility(View.VISIBLE);
        }
        if(dishes.getWant().contains(dish)){
            addToWant.setBackgroundColor(Color.GRAY);
            addToWant.setClickable(false);
        }
        dishImage.setImageResource(dish.getImageId());
        dishIsLove[0].setImageResource((dish.isLove()?R.drawable.heart_pad:R.drawable.heart));
        dishName.setText(dish.getName());
        dishFeel.setText("    口感："+dish.getFeel());
        dishMethod.setText("  烹饪方法："+(dish.getType()==1?"炒":".."));
        dishTime.setText("    耗时："+dish.getTotalTime());
        dishDiff.setText("  难易："+dish.getDifficulty());
        dishMate.setText("    主要食材："+dish.getMainMaterial());
        dishEnergy.setText("    热量："+dish.getEnergy());
        dishCost.setText("  成本："+dish.getPrice());
        dishIsLove[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dish.isLove()) {
                    dish.resetLove();
                    dishIsLove[0].setImageResource(R.drawable.heart);
                }
                else{
                    dish.setLove();
                    dishIsLove[0].setImageResource(R.drawable.heart_pad);
                }
            }
        });
        addToWant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.addWant(dish.getIndex());
                addToWant.setBackgroundColor(Color.GRAY);
                addToWant.setClickable(false);
            }
        });
        deleteFromWant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.deleteWant(dish.getIndex());
            }
        });
        doItNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
