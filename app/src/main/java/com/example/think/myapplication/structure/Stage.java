package com.example.think.myapplication.structure;

/**
 * Created by Think on 2016/12/18.
 */

public class Stage {
    private String process;
    private int type;//0:食材准备,1:菜品处理,2,无器具,3:蒸（蒸锅）,4:炒（炒锅）,5,烘烤(烤箱),6煲（电饭煲）,7煎（电饼铛）,8电煮锅
    private int clean;//0:无需清洗;1:可以清洗;2:必须清洗
    private int time;//时间，为0表示无需固定时间
    public Stage(String process, int type, int clean, int time){
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