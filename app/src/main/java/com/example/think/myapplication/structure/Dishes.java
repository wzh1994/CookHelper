package com.example.think.myapplication.structure;

import com.example.think.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Think on 2016/12/17.
 */



public class Dishes {

    private Vector<Dish> dishes;
    private List<Dish> willdo;
    private List<Dish> want;
    private List<Dish> show;
    private List<Dish> love;
    private Vector<Process> allProcesses;
    private Vector<MaterialPair> allMaterial;

    public Dishes(){
        dishes=new Vector<Dish>();
        want = new ArrayList<Dish>();
        show = new ArrayList<Dish>();
        love = new ArrayList<Dish>();
        willdo= new ArrayList<Dish>();
        initDishList();
    }

    public int dishNumbers(){
        return dishes.size();
    }

    public void clearWant(){
        want=new Vector<Dish>();
    }
    public void addWant(int index){
        if(!want.contains(dishes.get(index)))
            want.add(dishes.get(index));
    }
    public void deleteWant(int index){
        want.remove(dishes.get(index));
    }
    public void setAllWant(int index){
        allProcesses=dishes.get(index).getProcesses();
        allMaterial = dishes.get(index).getMaterials();
    }
    public void setAllWant(int[] index){
        allProcesses=new Vector<Process>();
        allMaterial = new Vector<MaterialPair>();
        //枚举法，计算index之和，然后判断
        int total=0;
        for (int i=0;index[i]>=0;i++){
            total+=index[i];
        }
        switch (total){
            case 20:
                ;
                break;
        }

    }

    public void setShow(int option){
        show = new ArrayList<>();
        //炒类别
        if (option==1){
            for (int i=0;i<dishes.size();i++){
                if (dishes.get(i).getType()==1) show.add(dishes.get(i));
            }
        }
        //最爱
        if (option==2){
            for (int i=0;i<dishes.size();i++){
                if (dishes.get(i).isLove()) show.add(dishes.get(i));
            }
        }
        //推荐
        if (option==3){
            for (int i=0;i<2;i++){
                show.add(dishes.get(i));
            }
        }
    }
    public void setShow(String search){
        System.out.println(search);
        show=new ArrayList<Dish>() ;
        for (int i=0;i<dishes.size();i++){
            if (dishes.get(i).getName().indexOf(search)>=0) show.add(dishes.get(i));
        }
    }
    public void resetAllWant(){
        allProcesses=null;
        allMaterial =null;
    }

    public void setWilldo(int id){
        willdo = new ArrayList<Dish>() ;
        willdo.add(dishes.get(id));
    }

    public void setWilldo(boolean want){
        if (want) {
            willdo = this.want;
        }
        else
            willdo=this.show;
    }




    public List<Dish> getLove() {
        return love;
    }

    public List<Dish> getShow() {
        return show;
    }

    public List<Dish> getWant(){
        return this.want;
    }

    public List<Dish> getWilldo() {
        return willdo;
    }

    private void initDishList(){
        Mate[] mate0={Mate.CUCUMBER,Mate.CORIANDER,Mate.CARROT,Mate.WHITE_SUGAR};
        float[] weight0={200,20,20,5};
        String[] process0={"1.黄瓜、香菜洗净备用，胡罗卜切小片","2.将黄瓜放在砧板上，左手抓住黄瓜一头，右手将菜刀横着用力拍黄瓜","3.将黄瓜切成小段","4.将黄瓜和胡萝卜加蒜末用小勺糖腌几分钟后，倒掉水，再用适量盐再腌10分钟左右，再倒去多余水","5.最后加入生菜拌匀再放置5分钟（不喜欢吃香菜的跳过此步）。吃前淋几滴香油"};
        int[] type0={1,2,2,2,2};
        int[] clean0={0,0,0,0,0};
        int[] time0={0,0,0,0,0};
        //名字，类别，难度，总时间，口感，图片，材料*2，工艺*4，序号
        dishes.addElement(new Dish("拍黄瓜",1,"困难",10,"咸鲜", R.drawable.dish_cucumber,mate0,weight0,process0,type0,clean0,time0,dishes.size()));
        dishes.get(0).setLove();
        dishes.addElement(new Dish("拍黄瓜2",2,"简单",20,"辣",R.drawable.dish_cucumber,mate0,weight0,process0,type0,clean0,time0,dishes.size()));


        //以下为模拟.仅有菜名和类别，难度，总时间，口感，图片，材料*2，
        Mate[] mateNull={};
        float[] weightNull={};
        String[] processNull={};
        int[] typeNull={};
        int[] cleanNull={};
        int[] timeNull={};
        //dishes.addElement(new Dish("",1,"",0,"",0,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
    }
}