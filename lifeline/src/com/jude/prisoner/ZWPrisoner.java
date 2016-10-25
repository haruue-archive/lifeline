package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by 张巍 on 2016/10/25.
 */
public class ZWPrisoner implements Prisoner {
    private int totalPersonNum, totalCountNum;

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
        if (index != totalPersonNum || index != 0) {
            int taken = totalCountNum - last;
            int x1, x2 = last / 2;
            try {
                int rows = index - 1;
                x1 = taken / rows;
                if(x1<totalPersonNum||x1>=totalCountNum/2){

                }
            } catch (Exception e) {
                x1 = 0;
            }

        } else {
            switch (index) {
                case 0:
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    public void result(boolean survived) {
        System.out.print("在这一局里，");
        if (survived) {
            System.out.println("ZW活了下去");
        } else {
            System.out.println("ZW死了。");
        }
    }
}
