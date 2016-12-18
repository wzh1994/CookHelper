package com.example.think.myapplication.structure;

/**
 * Created by Think on 2016/12/18.
 */

public class Process{
    private String process;
    private int type;//0:浸泡,腌制,1:切菜,2:蒸煮,3:凉拌,4:爆炒
    private int clean;//0:无需清洗;1:可以清洗;2:必须清洗
    private int time;//时间，为0表示无需固定时间
    public Process(String process,int type,int clean,int time){
        this.process=process;
        this.type=type;
        this.clean=clean;
        this.time=time;
    }

    public int getClean() {
        return clean;
    }

    public int getTime() {
        return time;
    }

    public int getType() {
        return type;
    }

    public String getProcess() {
        return process;
    }
}