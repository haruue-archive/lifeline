package com.jude.prisoner;

import com.jude.Prisoner;
import com.jude.Manager;

/**
 * Created by Mr.Jude on 2015/10/28.
 */
public class MaoPrisoner implements Prisoner {
    int totalCount;
    int totalPerson;

    @Override
    public String getName() {
        return "毛辉辉-2016211606";
    }

    @Override
    public void begin(Manager manager,int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {

        return (((totalCount-last)/(totalPerson-1))+last/totalPerson)/2;
    }

    @Override
    public void result(boolean survived) {

    }

}
