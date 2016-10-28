package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Queen on 2016/10/25 0025.
 */
public class XiaossicaPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;
    private Manager mManager;

    @Override
    public String getName() {
        return "周强2016210199";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        for (; totalPerson > totalCount; totalPerson++) {
            index = last + 1024;
        }
        return (((last + totalPerson + 15555 + index) * 1314 / (totalCount + last) / 213)) * 100 / (((totalCount - last) / (index + 1) + totalCount / totalPerson) / 2);
    }

    @Override
    public void result(boolean survived) {
    }
}
