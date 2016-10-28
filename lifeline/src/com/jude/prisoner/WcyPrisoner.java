package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by 王晨宇1 on 2016/10/27.
 */
public class WcyPrisoner implements Prisoner{
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
        return ((totalCount*totalPerson/last+100)+index-1/2);
    }
    public void result(boolean survived){
    }
}

