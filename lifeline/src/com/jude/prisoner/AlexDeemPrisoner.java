package com.jude.prisoner;

import com.jude.Prisoner;
import com.jude.Manager;
import java.util.Random;

/**
 * Created by alex-deem on 2016/10/27 0027.
 */

public class AlexDeemPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;
    private Random r = new Random();

    public String getName() {
        return "魏子凯2016215076";
    }

    public void begin(Manager manager,int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    public int take(int index, int last) {
        System.out.println("别问我是怎么活下来的！！") ;
        if(index%2==0){
        return (233/2-233/3+233/4-233/5+233/6-233/7+233/8-233/9) ;
        }
        else if (last%2==0) {
            final int n =r.nextInt(21) + 60;
            return n ;
        }
        else{
            final int i = r.nextInt() ;
            return i ;
        }
    }

    public void result(boolean survived){

    }

}