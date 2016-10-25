package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by lenovo on 2016/10/23.
 */
public class NookiaPrisoner implements Prisoner{
    private int totalCount;
    private int totalPerson;
    @Override
    public String getName() {
        return "谢佩君2015210502";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
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

    }
}
