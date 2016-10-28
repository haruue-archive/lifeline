package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by hasee on 2016/10/28.
 */
public class GodxuPrisoner  implements Prisoner {int totalCount;int totalPerson;
    public String getName(){
        return "许弟霜2016210244";
    }
    public void begin(Manager manager, int totalCount, int totalPerson){
        this.totalCount=totalCount;
        this.totalPerson=totalPerson;

    }
    public int take(int index,int last){
        //经过先知Godxu指引，这个数有天命在身。
        return (totalPerson/totalCount+totalCount/totalPerson-30);
    }public void result(boolean survive){
    }}

