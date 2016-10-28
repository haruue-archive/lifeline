package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by 张连芳 on 2016/10/28.
 */
public class MactorialPrisoner implements Prisoner {
    int totalCount;
    int totalPerson;

    @Override
    public String getName() {
        return "张连芳2016212687";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount=totalCount;
        this.totalPerson=totalPerson;

    }

    @Override
    public int take(int index, int last) {
        return totalCount/(totalPerson+3);
    }

    @Override
    public void result(boolean survived) {

    }
}
