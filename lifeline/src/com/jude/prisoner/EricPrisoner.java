package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by hasee on 2016/10/27.
 */
public class EricPrisoner implements Prisoner{
    int totalPerson;
    int totalCount;
    public String getName(){
        return "刘骏2016211147";
    }
    public void begin(Manager manager, int totalPerson, int totalCount ){
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;

    }
    public int take(int index, int last){
        return ((totalCount-last)/totalPerson);
    }
    public void result(boolean survived){

    }
}
