package com.example.think.myapplication.structure;

/**
 * Created by Think on 2016/12/18.
 */

public enum Mate{
    //英文大写(名称,蛋白质，脂肪，糖，价格)
    FLOUR("面粉",10.2f,1.1f, 72.6f,3.4f),
    TOFU("豆腐", 8.1f, 3.7f, 3.8f, 3.5f),
    LEAN("瘦肉", 20.3f, 6.2f, 1.5f, 18.5f),
    EGG("鸡蛋", 13.3f, 8.8f, 2.8f, 5f),
    VERMICELLI("粉丝", 0.8f, 0.2f, 82.6f, 10.6f),
    AGARIC("木耳", 12.1f, 1.5f, 35.7f, 30.0f),
    XIANGGU("香菇", 2.2f, 0.3f, 1.9f, 3.5f),
    ARACHIS_OIL("花生油", 0.0f, 99.9f, 0.0f, 10.5f),
    ALT("盐", 0f, 0f, 0f, 3.5f),
    CHICKEN_ESSENCE("鸡精", 10.7f, 2.8f, 32.5f, 17.5f),
    PEPPER_POWDER("胡椒粉", 9.6f, 2.2f, 74.6f, 62.0f),
    VINEGAR("醋", 2.1f, 0.3f, 4.9f, 5.8f),
    SCALLION("大葱", 1.7f, 0.3f, 5.2f, 0.9f),
    GINGER("姜", 1.3f, 0.6f, 7.6f, 4.1f),
    AMYLUM("淀粉", 0.2f, 0.5f, 86.0f, 9.8f),
    CORIANDER("香菜", 1.8f, 0.4f, 5.0f, 1.55f),
    SAUCE("酱油", 5.6f, 0.1f, 9.9f, 5f),
    STREAKY_PORK("五花肉", 8f, 54.1f, 1.8f, 14.5f),
    PUMPKIN("南瓜", 0.7f, 0.1f, 4.5f, 0.9f),
    GROUND_RICE("米粉", 0.4f, 0.8f, 85.8f, 4.8f),
    WHITE_SUGAR("白糖", 0.1f, 0f, 98.9f, 2.23f),
    OYSTER_SAUCE("耗油", 0f, 95.5f, 0.2f, 7f),
    DRUMSTICK("鸡腿", 16.0f, 13.0f, 0.0f, 11.5f),
    SAUSAGE("腊肠", 22.0f, 48.3f, 15.3f, 18f),
    CAPSICUM("干红椒",15.0f, 12.0f, 11.0f, 5.5f),
    PRICKLYASH("花椒", 6.7f, 8.9f, 37.8f, 12.5f),
    GARLIC("大蒜", 4.5f, 0.2f, 26.5f, 7.5f),
    COOKING_WINE("料酒", 0.3f, 0f, 0f, 15f),
    LIGHT_SOY_CAUCE("生抽", 4.8f, 0.1f, 0f, 8.8f),
    CUCUMBER("黄瓜", 0.8f, 0.2f, 2.4f, 1.6f),
    CARROT("胡萝卜",1.0f, 0.2f, 4.9f, 0.7f),
    WHITE_VINEGAR("白醋", 0.1f, 0.6f, 0f, 6.8f),
    BALM("香油", 0f, 99.7f, 0.2f, 48f),
    GREEN_PEPPER("青椒", 1.4f, 0.3f, 3.7f, 1.4f ),
    COLOR_PEPPER("彩椒", 1.3f, 0.2f, 3.1f, 2.1f)
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