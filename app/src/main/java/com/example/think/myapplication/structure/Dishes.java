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
    private Dish presentDish;
    private List<Stage> allProcesses;
    private List<MaterialPair> allMaterial;

    public Dishes(){
        dishes=new Vector<Dish>();
        want = new ArrayList<Dish>();
        show = new ArrayList<Dish>();
        love = new ArrayList<Dish>();
        willdo= new ArrayList<Dish>();
        initDishList();
    }

    public List<Stage> getAllProcesses() {
        return allProcesses;
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
    public void setShow(String search){
        System.out.println(search);
        show=new ArrayList<Dish>() ;
        for (int i=0;i<dishes.size();i++){
            if (dishes.get(i).getName().indexOf(search)>=0) show.add(dishes.get(i));
        }
    }

    public void setWilldo(int id){
        willdo = new ArrayList<Dish>() ;
        willdo.add(dishes.get(id));
        allProcesses = new ArrayList<Stage>();
        Vector<MaterialPair> allmat = dishes.get(id).getMaterials();
        String allMate ="    准备";
        for (int i=0;i<allmat.size();i++){
            if (i!=0) allMate+=",";
            allMate+=allmat.get(i).getName()+""+Integer.toString((int)allmat.get(i).getWeight())+"克";
        }
        allMate+="。";
        allProcesses.add(new Stage(allMate,0,0,0));
        for (int i=0;i<dishes.get(id).getProcesses().size();i++){
            allProcesses.add(dishes.get(id).getProcesses().get(i));
        }
    }

    public void setWilldo(boolean want){
        if (want) {
            willdo = this.want;
        }
        else
            willdo=this.show;
    }

    public Dish getPresentDish() {
        return presentDish;
    }

    public void setPresentDish(int index) {
        this.presentDish = dishes.get(index);
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
        addDish1();
        addDish2();
        addDish3();
        addDish4();
        addDish5();
        addDish6();
        addDish7();
        addDish8();
        addDish9();
        addDish10();
    }
    private void addDish1(){
        Mate[] mate={Mate.CUCUMBER,Mate.CORIANDER,Mate.CARROT,Mate.WHITE_SUGAR, Mate.SALT, Mate.LIGHT_SOY_CAUCE, Mate.WHITE_VINEGAR, Mate.BALM};
        float[] weight={200,20,20,5,3,5,5,3};
        String[] process={"黄瓜、香菜洗净备用，胡罗卜切小片","将黄瓜放在砧板上，左手抓住黄瓜一头，右手将菜刀横着用力拍黄瓜","将黄瓜切成小段","将黄瓜和胡萝卜加蒜末用小勺糖腌几分钟后，倒掉水，再用适量盐再腌10分钟左右，再倒去多余水","最后加入生菜拌匀再放置5分钟（不喜欢吃香菜的跳过此步）。吃前淋几滴香油"};
        int[] type={1,2,2,2,2};
        int[] clean={0,0,0,0,0};
        int[] time={0,0,3,6,0};
        //名字，类别，难度，总时间，口感，图片，材料*2，工艺*4，序号
        dishes.addElement(new Dish("拍黄瓜",1,"简单",30,"酸咸", R.drawable.dish_cucumber,mate,weight,process,type,clean,time,dishes.size()));
    }
    private void addDish2(){
        Mate[] mateNull={Mate.GREEN_PEPPER, Mate.COLOR_PEPPER, Mate.EGG, Mate.SALT, Mate.ARACHIS_OIL};//食材，Mate.英文大写
        float[] weightNull={100, 100, 150, 3, 3};//重量，要与上面食材对应
        //下面4个不用管
        String[] processNull={};
        int[] typeNull={};
        int[] cleanNull={};
        int[] timeNull={};
        //名字，类别，难度，总时间，口感，图片，材料*2，工艺*4，序号 序号始终为dishes.size()
        //类别按照 炒1 汤2 烤3 蒸4 拌5 煎6 炸7 炖8 烘9 卤10
        dishes.addElement(new Dish("剁椒鸡蛋",1,"简单",10,"咸鲜",R.drawable.dish_egg,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
    }
    private void addDish3(){
        Mate[] mateNull={Mate.STREAKY_PORK, Mate.PUMPKIN, Mate.GROUND_RICE, Mate.SCALLION, Mate.SAUCE, Mate.WHITE_SUGAR, Mate.COOKING_WINE, Mate.SALT, Mate.OYSTER_SAUCE, Mate.GINGER};//食材，Mate.英文大写
        float[] weightNull={300, 50, 100, 20, 3, 3, 5, 3, 5, 5};//重量，要与上面食材对应
        //下面4个不用管
        String[] processNull={};
        int[] typeNull={};
        int[] cleanNull={};
        int[] timeNull={};
        //名字，类别，难度，总时间，口感，图片，材料*2，工艺*4，序号 序号始终为dishes.size()
        //类别按照 炒1 汤2 烤3 蒸4 拌5 煎6 炸7 炖8 烘9 卤10
        dishes.addElement(new Dish("粉蒸肉",4,"简单",30,"酸咸",R.drawable.dish_meat,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
    }
    private void addDish4(){
        Mate[] mateNull={Mate.DRUMSTICK, Mate.SAUSAGE, Mate.CAPSICUM, Mate.PRICLYASH, Mate.GARLIC, Mate.WHITE_SUGAR, Mate.CHICKEN_ESSENCE, Mate.COOKING_WINE, Mate.SALT, Mate.LIGHT_SOY_CAUCE, Mate.ARACHIS_OIL};//食材，Mate.英文大写
        float[] weightNull={300, 100, 20, 10, 20, 3, 3, 5, 3, 5, 5};//重量，要与上面食材对应
        //下面4个不用管
        String[] processNull={};
        int[] typeNull={};
        int[] cleanNull={};
        int[] timeNull={};
        //名字，类别，难度，总时间，口感，图片，材料*2，工艺*4，序号 序号始终为dishes.size()
        //类别按照 炒1 汤2 烤3 蒸4 拌5 煎6 炸7 炖8 烘9 卤10
        dishes.addElement(new Dish("辣子鸡丁",7,"简单",30,"超辣",R.drawable.dish_chicken,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
    }
    private void addDish5(){
        Mate[] mateNull={Mate.TOFU, Mate.LEAN, Mate.EGG, Mate.VERMICELLI, Mate.AGARIC, Mate.XIANGGU, Mate.ARACHIS_OIL, Mate.SALT, Mate.CHICKEN_ESSENCE, Mate.PEPPER_POWDER, Mate.VINEGAR, Mate.SCALLION, Mate.GINGER, Mate.AMYLUM, Mate.BALM, Mate.CORIANDER, Mate.SAUCE};//食材，Mate.英文大写
        float[] weightNull={150, 150, 100, 50, 50, 50, 5, 3, 3, 2, 5, 20, 10, 30, 5, 5, 3};//重量，要与上面食材对应
        //下面4个不用管
        String[] processNull={};
        int[] typeNull={};
        int[] cleanNull={};
        int[] timeNull={};
        //名字，类别，难度，总时间，口感，图片，材料*2，工艺*4，序号 序号始终为dishes.size()
        //类别按照 炒1 汤2 烤3 蒸4 拌5 煎6 炸7 炖8 烘9 卤10
        dishes.addElement(new Dish("酸辣汤",2,"普通",20,"酸辣",R.drawable.dish_soup,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
    }
    private void addDish6(){
        Mate[] mateNull={Mate.POTATO, Mate.CARROT, Mate.GREEN_PEPPER, Mate.CAPSICUM, Mate.PRICLYASH, Mate.GARLIC, Mate.SALT, Mate.CHICKEN_ESSENCE, Mate.WHITE_SUGAR, Mate.WHITE_VINEGAR, Mate.BALM};//食材，Mate.英文大写
        float[] weightNull={300, 50, 100, 20, 10, 10, 5, 3, 3, 5, 5};//重量，要与上面食材对应
        //下面4个不用管
        String[] processNull={};
        int[] typeNull={};
        int[] cleanNull={};
        int[] timeNull={};
        //名字，类别，难度，总时间，口感，图片，材料*2，工艺*4，序号 序号始终为dishes.size()
        //类别按照 炒1 汤2 烤3 蒸4 拌5 煎6 炸7 炖8 烘9 卤10
        dishes.addElement(new Dish("酸辣土豆丝",1,"简单",20,"酸辣",R.drawable.dish_potato,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
    }
    private void addDish7(){
        Mate[] mateNull={Mate.TOFU, Mate.LEAN, Mate.GARLIC, Mate.GINGER, Mate.PRICLYASH, Mate.CAPSICUM, Mate.COOKING_WINE, Mate.SALT, Mate.AMYLUM, Mate.WHITE_SUGAR};//食材，Mate.英文大写
        float[] weightNull={300, 100, 20, 10, 15, 20, 5, 3, 50, 5};//重量，要与上面食材对应
        //下面4个不用管
        String[] processNull={};
        int[] typeNull={};
        int[] cleanNull={};
        int[] timeNull={};
        //名字，类别，难度，总时间，口感，图片，材料*2，工艺*4，序号 序号始终为dishes.size()
        //类别按照 炒1 汤2 烤3 蒸4 拌5 煎6 炸7 炖8 烘9 卤10
        dishes.addElement(new Dish("麻婆豆腐",1,"简单",20,"微辣",R.drawable.dish_tofu,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
    }
    private void addDish8(){
        Mate[] mateNull={Mate.BEEF, Mate.GREEN_PEPPER, Mate.SCALLION, Mate.GINGER, Mate.GARLIC, Mate.PEPPER_POWDER, Mate.WHITE_SUGAR, Mate.SALT, Mate.LIGHT_SOY_CAUCE, Mate.ARACHIS_OIL, Mate.EGG};//食材，Mate.英文大写
        float[] weightNull={300, 100, 20, 10, 15, 5, 5, 3, 10, 10, 50};//重量，要与上面食材对应
        //下面4个不用管
        String[] processNull={};
        int[] typeNull={};
        int[] cleanNull={};
        int[] timeNull={};
        //名字，类别，难度，总时间，口感，图片，材料*2，工艺*4，序号 序号始终为dishes.size()
        //类别按照 炒1 汤2 烤3 蒸4 拌5 煎6 炸7 炖8 烘9 卤10
        dishes.addElement(new Dish("杭椒牛柳",1,"普通",20,"微辣",R.drawable.dish_beef,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
    }
    private void addDish9(){
        Mate[] mateNull={Mate.MUTTON, Mate.SCALLION, Mate.GINGER, Mate.CORIANDER, Mate.VINEGAR, Mate.SALT, Mate.PEPPER_POWDER};//食材，Mate.英文大写
        float[] weightNull={300, 100, 10, 10, 5, 3, 3};//重量，要与上面食材对应
        //下面4个不用管
        String[] processNull={};
        int[] typeNull={};
        int[] cleanNull={};
        int[] timeNull={};
        //名字，类别，难度，总时间，口感，图片，材料*2，工艺*4，序号 序号始终为dishes.size()
        //类别按照 炒1 汤2 烤3 蒸4 拌5 煎6 炸7 炖8 烘9 卤10
        dishes.addElement(new Dish("葱爆羊肉",1,"普通",10,"五香",R.drawable.dish_mutton,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
    }
    private void addDish10(){
        Mate[] mateNull={Mate.SHRIMP, Mate.CUCUMBER, Mate.SCALLION, Mate.GARLIC, Mate.SALT, Mate.AMYLUM};//食材，Mate.英文大写
        float[] weightNull={300, 200, 10, 10, 5, 30};//重量，要与上面食材对应
        //下面4个不用管
        String[] processNull={};
        int[] typeNull={};
        int[] cleanNull={};
        int[] timeNull={};
        //名字，类别，难度，总时间，口感，图片，材料*2，工艺*4，序号 序号始终为dishes.size()
        //类别按照 炒1 汤2 烤3 蒸4 拌5 煎6 炸7 炖8 烘9 卤10
        dishes.addElement(new Dish("黄瓜虾仁",1,"简单",10,"原味",R.drawable.dish_shrimp,mateNull,weightNull,processNull,typeNull,cleanNull,timeNull,dishes.size()));
    }
}