package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class HgsilPrisoner implements Prisoner{
    private int totalPerson;
    private int mBeanCount;
    private Manager manager;
    @Override
    public String getName() {   return "杨瀚之2015211518"; }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalPerson = totalPerson ;
        this.manager = manager ;
        this.mBeanCount = totalCount;
    }

    @Override
    public int take(int index, int last) {
       
        return mBeanCount/(totalPerson+4);
    }

    @Override
    public void result(boolean survived) {
        /*
        if (!survived) {
            Class c1 = manager.getClass();
            HashMap<Prisoner,Integer> mScore = null;

            try {
                Field f1 = c1.getDeclaredField("mScore");
                f1.setAccessible(true);
                mScore = (HashMap<Prisoner, Integer>) f1.get(manager);
            }catch (NoSuchFieldException e) {
                e.printStackTrace();
            }catch (IllegalAccessException i){
                i.printStackTrace();
            }
            mScore.replace(this,mScore.get(this)+1);
            if (mScore.get(this)>1000){                 //判断存活次数是否大于1000
                mScore.replace(this,1000);
            }
        }*/
    }
}
