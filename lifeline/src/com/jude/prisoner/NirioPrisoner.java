package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by Administrator on 2016/10/27.
 */
public class NirioPrisoner implements Prisoner {
    int totalCount;
    int totalPerson;

    @Override
    public String getName() {
        return "张力升2016211895";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        int count;
        if(index<2)
        {
            count = (totalCount/totalPerson+last/(index+1));
        }
        else if (index>2&&index<4)
        {
            count = ((totalCount/last)*(index+4)+totalCount/(totalPerson+4));
        }
        else
        {
            count = (((totalCount-last)/(index+1) + totalCount/totalPerson)/2);
        }
        return count;
    }

    @Override
    public void result(boolean survived) {

    }
}
