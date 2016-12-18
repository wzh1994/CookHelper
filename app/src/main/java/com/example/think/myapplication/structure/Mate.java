package com.example.think.myapplication.structure;

/**
 * Created by Think on 2016/12/18.
 */

public enum Mate{
    //英文大写(名称,蛋白质，脂肪，糖，价格)
    FLOUR("面粉",10.2f,1.1f, 72.6f,3.4f)
    ;
    private String name;
    private float protein;
    private float fat;
    private float carbohydrate;
    private float price;
    private Mate(String name,float protein,float fat,float carbohydrate,float price){
        this.name=name;
        this.protein=protein;
        this.fat=fat;
        this.carbohydrate=carbohydrate;
        this.price=price;
    }
    public float getProtein(){
        return this.protein;
    }

    public float getCarbohydrate() {
        return this.carbohydrate;
    }

    public float getFat() {
        return this.fat;
    }

    public float getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
    public float getEnergy(){
        return 4*this.protein+4*this.carbohydrate+9*this.fat;
    }
};