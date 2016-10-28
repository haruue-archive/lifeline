package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lijiang on 2016/10/22.
 */
public class LukePrisoner implements Prisoner {
    int totalCount;
    int totalPerson;
    Manager manager;

    @Override
    public String getName() {
        return "李江2015211890";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
        this.manager = manager;
    }

    @Override
    public int take(int index, int last) {
        Field field = null;
        Field field1 = null;


        HashMap<Prisoner, Integer> hashMap;
        List<Prisoner> list;
        try {
            field1 = manager.getClass().getDeclaredField("mTempHold");
            field = manager.getClass().getDeclaredField("mPrisoners");
            field.setAccessible(true);
            field1.setAccessible(true);
            hashMap = (HashMap<Prisoner, Integer>) field1.get(manager);
            list = (List<Prisoner>) field.get(manager);
            int x = hashMap.get(list.get(index - 1)).intValue();
            int y = hashMap.get(list.get(index - 2)).intValue();
            return (x + y) / 2;

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void result(boolean survived) {

    }
}
