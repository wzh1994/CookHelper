package com.example.think.myapplication.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.think.myapplication.R;
import com.example.think.myapplication.structure.Dish;

import java.util.List;

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
        Dish dish = getItem(position); // 获取当前项的Fruit实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView dishImage = (ImageView) view.findViewById(R.id.dish_image);
        TextView dishName = (TextView) view.findViewById(R.id.dish_name);
        TextView dishMate = (TextView) view.findViewById(R.id.dish_material);
        TextView dishFeel = (TextView) view.findViewById(R.id.dish_feel);
        TextView dishMethod = (TextView) view.findViewById(R.id.dish_method);
        TextView dishTime = (TextView) view.findViewById(R.id.dish_time);
        TextView dishDiff = (TextView) view.findViewById(R.id.dish_difficulty);
        TextView dishEnergy = (TextView) view.findViewById(R.id.dish_energy);
        TextView dishCost = (TextView) view.findViewById(R.id.dish_cost);
        dishImage.setImageResource(dish.getImageId());
        dishName.setText(dish.getName());
        dishFeel.setText("    口感："+dish.getFeel());
        dishMethod.setText("  烹饪方法："+(dish.getType()==1?"炒":".."));
        dishTime.setText("    耗时："+dish.getTotalTime());
        dishDiff.setText("  难易："+dish.getDifficulty());
        dishMate.setText("    主要食材："+dish.getMainMaterial());
        dishEnergy.setText("    热量："+dish.getEnergy());
        dishCost.setText("  成本："+dish.getPrice());
        return view;
    }
}
