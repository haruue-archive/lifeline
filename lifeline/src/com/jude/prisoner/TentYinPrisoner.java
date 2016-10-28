package com.jude.prisoner;

import com.jude.Prisoner;
import com.jude.Manager;

/**
 * Created by Administrator on 2016/10/27.
 */
public class TentYinPrisoner implements Prisoner{
    private int totalCount;
    private int totalPerson;
    private Manager manager;

    @Override
    public String getName(){return"尹心健2016214807";}

    @Override
    public void begin(Manager manager,int totalPerson,int totalCount){
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
        this.manager = manager;
    }

    @Override
    public int take(int index,int last) {
        int a =((totalCount-last)/(index+1) + totalCount/totalPerson)/2;
        int b =(totalCount / totalPerson + (index + last+130)) / 8;
        int c =(totalCount / totalPerson + (index + last+b)) / 8 - 14;
        if(a>c){
            return(c+1);
        }
        else if(a<c){
            return(a+1);
        }
        else{
            return(a);
        }//PS:我突然觉得我好贱啊
    }

    @Override
    public void result(boolean survived){}
}
