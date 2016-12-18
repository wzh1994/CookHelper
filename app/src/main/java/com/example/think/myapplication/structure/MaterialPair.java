package com.example.think.myapplication.structure;

/**
 * Created by Think on 2016/12/18.
 */

public class MaterialPair{
    private Mate material;//材料
    private float weight;//重量，单位：克
    public MaterialPair(Mate material,float weight){
        this.material=material;
        this.weight=weight;
    }
    public float getProtein(){
        return this.material.getProtein()*weight/100;
    }

    public float getCarbohydrate() {
        return this.material.getCarbohydrate()*weight/100;
    }

    public float getFat() {
        return this.material.getFat()*weight/100;
    }

    public float getPrice() {
        return this.material.getPrice()*weight/500;
    }

    public String getName() {
        return this.material.getName();
    }
    public float getEnergy(){
        return this.material.getEnergy()*weight/100;
    }
}