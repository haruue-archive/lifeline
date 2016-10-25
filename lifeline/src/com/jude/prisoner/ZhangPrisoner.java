package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by 张 on 2016/10/25.
 */
public class ZhangPrisoner implements Prisoner {
    int totalCount;
    int totalPerson;
    @Override
    public String getName() {
        return "张中豪2016212027";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        return (totalCount / totalPerson + (index + last)) / 8;
    }

    @Override
    public void result(boolean survived) {

    }
}
