package com.jude.prisoner;
import com.jude.Manager;
import com.jude.Prisoner;
/**
 * Created by Administrator on 2016/10/26 0026.
 */
public class KiraPrisoner implements Prisoner{
    private int players;
    private int toys;
    private Manager manager;
    public String getName() {return "许景益2016211893";}
    public void begin(Manager manager, int totalPerson, int totalCount){
        this.players=totalPerson;
        this.toys=totalCount;
        this.manager=manager;
    }
    //轮到你取豆子
    public  int take(int index, int last){
     if(players==3)
     { if (index==1)
        {
            return last;
        }
        else
        {
            return   ((toys-last)/(players-index-1) + toys/players)/2;
        }
     }
     else {
         if (index==2)
         {
             return last;
         }
         else
         {
             return   ((toys-last)/(players-index-1) + toys/players)/2;
         }

     }
    }
    //最后告诉你活着还是死了
    public  void result(boolean survived)  {

    }
}
