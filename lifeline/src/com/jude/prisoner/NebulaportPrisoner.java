package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class NebulaportPrisoner implements Prisoner {
    int totalCount;
    int totalPerson;

    @Override
    public String getName() {
        return "张丽姝2016214330";
    }

    @Override
    public void begin(Manager manager,int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;

    }
    @Override
    public int take(int index, int last) {

        return (Math.max(totaCount-last)/(index+1)-1,last/(totalCount-indext-1)-1));
    }

    @Override
    public void result(boolean survived) {
    }
}