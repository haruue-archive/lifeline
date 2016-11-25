package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by Akaashi on 2016/10/26.
 */
public class AkaashiPrisoner implements Prisoner {
    int totalCount;
    int totalPerson;

    @Override
    public String getName() {
        return "王馨悦2016214280";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount=totalCount;
        this.totalPerson=totalPerson;
    }

    @Override
    public int take(int index, int last) {

        return (totalCount-index-3)/(totalPerson+3)-((totalCount-last-3)/(totalPerson+3))/3;
    }

    @Override
    public void result(boolean survived) {

    }
}
