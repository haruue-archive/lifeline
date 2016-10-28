package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * wow
 * Created by 张巍 on 2016/10/25.
 */
public class ZWPrisoner implements Prisoner {
    private int totalPersonNum, totalCountNum;
    private int dies = 0, lives = 0, i = 0;
    private int ave[] = new int[10000];

    @Override
    public String getName() {
        return "张巍2016214874";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        System.out.println("ZW说，他有一个manager，旁边有" + (totalPerson - 1) + "个人在和他共同进行这个游戏。我们有" + totalCount + "个豆子。");
        totalPersonNum = totalPerson;
        totalCountNum = totalCount;
    }

    @Override
    public int take(int index, int last) {//index是你的序号，last是剩下的个数。
        int x1 , taken = totalCountNum - last, n = 10, m = 1;
        if (index == 0) {
            switch (i) {
                case 0:
                    x1=totalCountNum/totalPersonNum;
                    break;
                default:
                    x1 =ave[i-1];
            }
        } else {
            x1 = (taken / index) + m * (int) Math.floor(n * Math.random());
        }
        ave[i] = x1;

        i++;
        return x1;
    }

    @Override
    public void result(boolean survived) {
        if (survived) {
            lives++;
        } else {
            dies++;
        }
    }

}
//↓一段失败的算法
/*int x1 = 0, taken = totalCountNum - last,x2 = last;

        if (index != totalPersonNum || index != 0) {
          try {
                if ((int) Math.floor(2 * Math.random()) == 1) {
                    x1 = (taken / index) + (int) Math.floor(5 * Math.random());
                } else {
                    x1 = (taken / index) - (int) Math.floor(5 * Math.random());
                }
            } catch (Exception e) {
                x1 = 0;
            }
            for (; x2 < totalPersonNum*((totalCountNum/(totalPersonNum))+(int) Math.floor(5 * Math.random())); x2 += (int) Math.floor(5 * Math.random())) ;
            for (; x1 < totalPersonNum*((totalCountNum/(totalPersonNum))+(int) Math.floor(5 * Math.random())); x1 += (int) Math.floor(5 * Math.random())) ;

        } else {
            switch (index) {
                case 0:
                    x1 = totalPersonNum;
                    for (int i = 0; i < totalPersonNum / 2; i++) {
                        x1 = (x1 / 2) + (int) Math.floor(5 * Math.random());
                        x1 -= (int) Math.floor(5 * Math.random());
                    }
                    break;
                default:
                    if (last < totalPersonNum)
                    {return last;}
                    if (last>totalCountNum/2)
                    {
                        int out=last/2+(int) Math.floor(5 * Math.random());
                        return out;
                    }
                        break;
            }
        }

        if (x1 == 0) {return x2;}
        else
        if (x2 == 0) {return x1;}
        else
            if (x1>last){
                for (;x1>last;x1/=2);
            }
            return Math.min(x1, x2);*/

//失败的学习算法

  /* if (dies + lives == 20) {
            int sum = 0;
            int aveg = 0;
            if (dies > lives) {
                for (int t = 0; t < 20; t++) {
                    sum += ave[i - t];
                }
                aveg = sum / 20;
                quan = aveg - ave[i];
            }
        }*/