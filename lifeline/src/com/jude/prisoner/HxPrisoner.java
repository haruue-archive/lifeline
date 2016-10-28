package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by alienware on 2016/10/25.
 */
public class HxPrisoner implements Prisoner{
   private int totalPerson;
    private int totalCount;
    private Manager manager;

    @Override
    public String getName(){
        return("黄曦2016215069");
    }
    @Override
    public void begin(Manager manager, int totalPerson, int totalCount){
        this.manager=manager;
        this.totalCount=totalCount;
        this.totalPerson=totalPerson;
    }
    @Override
    public int take(int index, int last){
        if(totalPerson<20){
return(totalPerson+totalCount/20+20);}
        else return (totalPerson*2+totalCount/totalPerson);
    }
    @Override
    public void result(boolean survived) {
    }
}
