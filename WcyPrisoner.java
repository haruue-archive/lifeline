package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by 王晨宇1 on 2016/10/27.
 */
public class WcyPrisoner implements Prisoner,RandomDemo{
    int totalCount;
    int totalPerson;
    Manager manager;
    public String getName(){
        return "王晨宇2016215067";
    }
    public void begin(Manager manager, int totalPerson, int totalCount){
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
        this.manager = manager;
    }
    public int take(int index, int last){
        return ((totalCount-last)/(index+1) + totalCount/totalPerson)/2;
    }
    public void result(boolean survived){
    }
}

