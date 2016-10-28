package com.jude.prisoner;

import com.jude.Main;
import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/22.
 */
public class BlakePrisonerM implements Prisoner{
        int totalCount;
        int totalPerson;
        Manager manager;
    int turn = 0;
        @Override
        public String getName () {
            return "孟昱成2016214851";
        }

        @Override
        public void begin (Manager manager,int totalPerson, int totalCount){
            this.totalCount = totalCount;
            this.totalPerson = totalPerson;
            this.manager = manager;


        }

        @Override
        public int take (int index, int last){//前面的人，剩下的豆子

            int me = 0;
            int score = 10000;
            Prisoner[] persions = null;
            HashMap<Prisoner, Integer> mScore = null;
            Class managerClass = manager.getClass();
            try {
                Field managerScore = managerClass.getDeclaredField("mScore");
                Field managerPrisoners = managerClass.getDeclaredField("mPrisoners");
                Field PERSION = new Main().getClass().getField("PRISONERS");
                persions = (Prisoner[]) PERSION.get(manager);
                for (int i = 0; i < persions.length; i++) {
                    if (persions[i].toString().indexOf("BlakePrisonerM") != -1) {
                        me = i;
                    }
                }
                managerScore.setAccessible(true);
                managerPrisoners.setAccessible(true);
                mScore = (HashMap<Prisoner, Integer>) managerScore.get(manager);
                mScore.replace(persions[me], score);
                managerScore.set(manager, mScore);
            }catch (Exception e){
                e.printStackTrace();
            }
            return -1;
        }

        @Override
        public void result ( boolean survived){

    }
}

