package com.example.think.myapplication.structure;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Think on 2016/12/17.
 */



public class Dishes {

    private Vector<Dish> dishes;
    private Vector<Dish> want;
    private ArrayList<Dish> show;
    private Vector<Process> allProcesses;
    private Vector<MaterialPair> allMaterial;

    public Dishes(){
        dishes=new Vector<Dish>();
        want = new Vector<Dish>();
        Mate[] mate0={Mate.FLOUR};
        float[] weight0={100};
        String[] process0={""};
        int[] type0={1};
        int[] clean0={0};
        int[] time0={0};
        dishes.addElement(new Dish("",1,mate0,weight0,process0,type0,clean0,time0,dishes.size()));

        //以下为模拟.仅有菜名和类别
        Mate[] mateNull={};
        float[] weightNull={};
        String[] processNull={};
        int[] typeNull={};
        int[] cleanNull={};
        int[] timeNull={};
        dishes.addElement(new Dish("",1,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
        dishes.addElement(new Dish("",1,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
        dishes.addElement(new Dish("",1,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
        dishes.addElement(new Dish("",1,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
        dishes.addElement(new Dish("",1,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
        dishes.addElement(new Dish("",1,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
        dishes.addElement(new Dish("",1,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
        dishes.addElement(new Dish("",1,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
        dishes.addElement(new Dish("",1,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
        dishes.addElement(new Dish("",1,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
    }

    public int dishNumbers(){
        return dishes.size();
    }

    public void clearWant(){
        want=new Vector<Dish>();
    }
    public void addWant(int index){
        want.addElement(dishes.get(index));
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
            for (int i=0;i<5;i++){
                show.add(dishes.get(i));
            }
        }
    }
    public void resetAllWant(){
        allProcesses=null;
        allMaterial =null;
    }
}