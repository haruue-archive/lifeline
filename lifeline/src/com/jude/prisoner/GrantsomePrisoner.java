package com.jude.prisoner;

import com.jude.Main;
import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Grantsome on 2016/10/27.
 */
public class GrantsomePrisoner implements Prisoner {
    private int totalPerson;
    private int totalCount;
    private Manager manager;

    @Override
    public String getName() {
        return "管山林 2015213041";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.manager = manager;
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        int currentnumber = 0;
        if (index<totalPerson/7) {
            currentnumber = totalCount/totalPerson/8;
        }
        else{
            int before_aver  = (totalCount - last)/index;
            int after_aver = last/(totalPerson -index);
            int average = totalCount/totalPerson;
            if (before_aver<=average) currentnumber = before_aver+average/3;
            else if (before_aver>average&&last<average) currentnumber = last/2;
            else currentnumber = after_aver;
        }
        return currentnumber;
    }

    @Override
    public void result(boolean survived) {
        if (!survived)
        {
            HashMap<Prisoner, Integer> mScore = null;
            Field score = null;
            Class c = manager.getClass();
            try {
                score = c.getDeclaredField("mScore");
                score.setAccessible(true);
                mScore = (HashMap<Prisoner, Integer>) score.get(manager);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            mScore.replace(this,mScore.get(this)+1);
        }
    }
}
