package com.jude.prisoner;
import com.jude.Prisoner;
import com.jude.Manager;


public class JerryPrisoner implements Prisoner {
    int totalCount;
    int totalPerson;

    @Override
    public String getName() {
        return "张继磊2016214992";
    }

    @Override
    public void begin(Manager manager,int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
       {
            return(((totalCount-last)/(totalPerson-index+100))+100);
        }
    }

    @Override
    public void result(boolean survived) {

    }

}

