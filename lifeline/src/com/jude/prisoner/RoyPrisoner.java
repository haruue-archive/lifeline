package com.jude.prisoner;
import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 89294 on 2016/10/27.
 */
public class RoyPrisoner implements Prisoner{
    private int totalCount;
    private int totalPerson;
    private Manager mManager;

    @Override
    public String getName(){return"罗秀妮2016214217";}

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        mManager = manager;
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
}

    @Override
    public int take(int index, int last) {
        return((index/4-1)+(last/2-1))/2;
    }

    @Override
    public void result(boolean survived) {

    }
}
