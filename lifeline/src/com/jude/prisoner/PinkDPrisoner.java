package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by PinkD on 2016/10/28.
 * PinkDPrisoner
 */
public class PinkDPrisoner implements Prisoner{
    @Override
    public String getName() {
        return "PinkD2015211478";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {

    }

    @Override
    public int take(int index, int last) {
        return last;
    }

    @Override
    public void result(boolean survived) {

    }
}

