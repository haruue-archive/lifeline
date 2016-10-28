package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.util.Random;

/**
 * Created by ingra on 2016-10-27.
 */
public class XuanYuPrisoner implements Prisoner {

    @Override
    public String getName() {
        return "杨子聪2015211670";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {

    }

    @Override
    public int take(int index, int last) {
        return (int) (Math.random()*150);
    }

    @Override
    public void result(boolean survived) {

    }
}
