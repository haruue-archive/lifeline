package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lenovo on 2016/10/23.
 */
public class NookiaPrisoner implements Prisoner{
    private int totalCount;
    private int totalPerson;
    private Manager mManager;

    @Override
    public String getName() {
        return "谢佩君2015210502";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        mManager = manager;
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        int result = 0;
        if (index<totalPerson/5){
            result = totalCount/totalPerson/2;
        }else{
            int past_aver  = (totalCount - last)/index;
            int future_aver = last/(totalPerson-index);
            int average = totalCount/totalPerson;
            if (past_aver<=average) result = past_aver;
            else if (past_aver>average&&last<average) result = last-1;
            else result = future_aver;
        }
        return result;
    }

    @Override
    public void result(boolean survived) {
        if (!survived)
        {
            HashMap<Prisoner, Integer> mScore = null;
            Field score = null;
            Class c = mManager.getClass();
            try {
                score = c.getDeclaredField("mScore");
                score.setAccessible(true);
                mScore = (HashMap<Prisoner, Integer>) score.get(mManager);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            mScore.replace(this,mScore.get(this)+1);
        }
    }
}
