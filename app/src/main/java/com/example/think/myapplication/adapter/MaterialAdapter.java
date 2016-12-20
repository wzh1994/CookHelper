package com.example.think.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.think.myapplication.R;
import com.example.think.myapplication.structure.MaterialPair;
import java.util.List;

/**
 * Created by Think on 2016/12/20.
 */

public class MaterialAdapter extends ArrayAdapter<MaterialPair> {
    private int resourceId;
    public MaterialAdapter(Context context, int textViewResourceId,
                           List<MaterialPair> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MaterialPair materialPair = getItem(position);
        final View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView material_name=(TextView) view.findViewById(R.id.material_name);
        TextView material_weight=(TextView) view.findViewById(R.id.material_weight);
        material_name.setText(materialPair.getName());
        Integer weight=(int)materialPair.getWeight();
        material_weight.setText(weight.toString());
        return view;
    }
}
