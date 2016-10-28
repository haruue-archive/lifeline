package com.jude.prisoner;

import com.jude.Main;
import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * Created by namercx on 2016/10/24.
 */
public class TouchTheWorldPrisoner implements Prisoner {
    int totalCount;
    int totalPerson;

    @Override
    public String getName() {
        return "荣长霄2016210408";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last){
        if(index == 0){
            //第一个拿....我真想拿last...
            return last/(totalPerson+10);
        }else if(index == 1){
            if(last != totalCount){
                int rand = (int) (0+Math.random()*(1 - 0+1));
                //让我先洗把脸....等等海关叔叔你们抓错了！我不是非洲人！
                if(rand == 1)
                    return (totalCount-last)-1;
                else
                    return (totalCount-last)+1;
            }else                                  //前面那人竟然自杀！
                return last/(totalPerson+10);
        }else if(index == 2){
            //我觉得前面有人要自杀
            return (totalCount-last)/2*63/50;
        }else
            return (totalCount-last)/index+2;
    }

    @Override
    public void result(boolean survived) {

    }

}
