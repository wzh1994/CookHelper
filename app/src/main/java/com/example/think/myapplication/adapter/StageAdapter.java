package com.example.think.myapplication.adapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.think.myapplication.R;
import com.example.think.myapplication.structure.Stage;

import java.util.List;

/**
 * Created by Think on 2016/12/20.
 */

public class StageAdapter extends ArrayAdapter<Stage> {
    private int resourceId;
    public StageAdapter(Context context, int textViewResourceId,
                        List<Stage> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Stage stage = getItem(position);
        final View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        final CountDownTimer ct;
        final TextView timeRemained = (TextView)view.findViewById(R.id.time_remained);
        final TextView timeTotal = (TextView)view.findViewById(R.id.time_total);
        final Button start = (Button)view.findViewById(R.id.start_count);
        final Button stop = (Button)view.findViewById(R.id.stop_count);
        LinearLayout timeModule = (LinearLayout) view.findViewById(R.id.time_module);
        if (stage.getTime()==0){
            timeModule.setVisibility(View.INVISIBLE);
        }
        else{
            timeModule.setVisibility(View.VISIBLE);
            timeRemained.setText("剩余时间："+Integer.toString(stage.getTime()*60));
            timeTotal.setText("共需要："+Integer.toString(stage.getTime()*60)+"秒");
        }
        ct=new CountDownTimer(stage.getTime()*60000, 1000) {
            public void onTick(long millisUntilFinished) {
                timeRemained.setText("剩余时间: " + millisUntilFinished / 1000);
            }
            public void onFinish() {  //倒计时结束。
                timeRemained.setText("时间到!");
            }
        };
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setVisibility(View.GONE);
                stop.setVisibility(View.VISIBLE);
                ct.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setVisibility(View.VISIBLE);
                stop.setVisibility(View.GONE);
                ct.cancel();
            }
        });
        TextView title=(TextView) view.findViewById(R.id.title);
        TextView process_content=(TextView) view.findViewById(R.id.process_content);
        title.setText("阶段"+Integer.toString(position+1)+"： "+(stage.getType()==0?"食材准备":stage.getType()==1?"食材处理":stage.getType()==2?"凉拌":stage.getType()==3?"蒸":stage.getType()==4?"炒":stage.getType()==5?"烘烤":stage.getType()==6?"煲":stage.getType()==7?"煎":"煮"));
        process_content.setText(stage.getProcess());
        return view;
    }
}
