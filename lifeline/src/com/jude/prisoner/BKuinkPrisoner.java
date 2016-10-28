package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by asus-pc on 2016/10/28.
 */
public class BKuinkPrisoner implements Prisoner {
    int totalPerson;
    int totalCount;

    @Override
    public String getName() {
        return "王泽鸿2015211676";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalPerson = totalPerson;
        this.totalCount = totalCount;
    }

    @Override
    public int take(int index, int last) {
        return totalCount / totalPerson;
    }

    @Override
    public void result(boolean survived) {

    }
}
