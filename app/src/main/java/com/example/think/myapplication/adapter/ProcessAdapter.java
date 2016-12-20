package com.example.think.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.think.myapplication.R;
import com.example.think.myapplication.structure.Stage;
import java.util.List;

/**
 * Created by Think on 2016/12/20.
 */

public class ProcessAdapter extends ArrayAdapter<Stage> {
    private int resourceId;
    public ProcessAdapter(Context context, int textViewResourceId,
                          List<Stage> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Stage process = getItem(position);
        final View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView process_seq=(TextView) view.findViewById(R.id.process_seq);
        TextView process_content=(TextView) view.findViewById(R.id.process_content);
        System.out.println(process.getProcess());
        process_seq.setText(Integer.toString(position+1)+"：");
        process_content.setText(process.getProcess());
        return view;
    }
}
