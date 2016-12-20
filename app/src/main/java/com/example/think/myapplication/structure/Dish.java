package com.example.think.myapplication.structure;

import java.util.Vector;

/**
 * Created by Think on 2016/12/18.
 */

public class Dish{
    private String name;
    private int index;
    private int type;//1-10 分别代表
    private int imageId;
    private boolean love=false;
    private int totalTime;
    private String feel;
    private String difficulty;
    private Vector<MaterialPair> materials;
    private Vector<Stage> processes;
    //名字，类别，难度，总时间，口感，图片，材料，工艺，序号
    public Dish(String name, int dishType ,String difficulty,int totalTime,String feel,int imageId,Mate[] mate, float[] weight, String[] process, int[] type, int[] clean, int[] time, int index){
        this.materials=new Vector<MaterialPair>();
        this.processes=new Vector<Stage>();
        this.name=name;
        this.imageId=imageId;
        this.difficulty=difficulty;
        this.totalTime=totalTime;
        this.feel=feel;
        this.index=index;
        this.type=dishType;
        for (int i=0;i<mate.length;i++){
            materials.addElement(new MaterialPair(mate[i],weight[i]));
        }
        for (int i=0;i<process.length;i++){
            processes.addElement(new Stage(process[i],type[i],clean[i],time[i]));
        }
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public String getFeel() {
        return feel;
    }

    public int getImageId() {
        return imageId;
    }

    public boolean isLove() {
        return love;
    }

    public void setLove() {
        this.love = true;
    }
    public void resetLove() {
        this.love = false;
    }

    public int getIndex() {
        return index;
    }

    public Vector<MaterialPair> getMaterials() {
        return materials;
    }

    public Vector<Stage> getProcesses() {
        return processes;
    }

    public int getProtein() {
        float protein = 0;
        for (int i = 0; i < this.materials.size(); i++) {
            protein += this.materials.get(i).getProtein();
        }
        return (int)protein;
    }

    public int getCarbohydrate() {
        float carbohydrate = 0;
        for (int i = 0; i < this.materials.size(); i++) {
            carbohydrate += this.materials.get(i).getCarbohydrate();
        }
        return (int)carbohydrate;
    }

    public int getFat() {
        float fat = 0;
        for (int i = 0; i < this.materials.size(); i++) {
            fat += this.materials.get(i).getFat();
        }
        return (int)fat;
    }

    public int getPrice() {
        float price = 0;
        for (int i = 0; i < this.materials.size(); i++) {
            price += this.materials.get(i).getPrice();
        }
        price+=0.99;
        return (int)price;
    }

    public int getEnergy(){
        float energy = 0;
        for (int i = 0; i < this.materials.size(); i++) {
            energy += this.materials.get(i).getEnergy();
        }
        energy+=0.99;
        return (int)energy;
    }
    public String getMainMaterial(){
        return materials.get(0).getName()+","+materials.get(1).getName()+","+materials.get(2).getName()+"...";
    }
}