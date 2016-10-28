package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by Zou on 2016/10/28.
 */
public class ZouPrisoner implements Prisoner {
    private int totalPerson;
    private int totalCount;
    @Override
    public String getName() {
        return "邹晟2015211529";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalPerson=totalPerson;
        this.totalCount=totalCount;
    }

    @Override
    public int take(int index, int last) {
        return ((totalCount/index + totalCount/totalPerson)+222)/6;
        //反射还没弄懂呢于是整了这么个数还是蛮玄学的很少挂掉。。。。。。
    }

    @Override
    public void result(boolean survived) {

    }
}
