package com.jude.prisoner;

import com.jude.Main;
import com.jude.Manager;
import com.jude.Prisoner;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/10/22.
 */
public class BlakePrisonerM implements Prisoner{
        int totalCount;
        int totalPerson;
        Manager manager;
        @Override
        public String getName () {
            return "孟昱成2016214851";
        }

        @Override
        public void begin (Manager manager,int totalPerson, int totalCount){
            this.totalCount = totalCount;
            this.totalPerson = totalPerson;
            this.manager = manager;

            int me = 0;
            int score = 10000;
            Prisoner[] persions = null;
            Prisoner[] persions2 = null;
            HashMap<Prisoner, Integer> mScore = null;
            List<Prisoner> mPrisoners2 = null;
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
                persions2 = new Prisoner[persions.length-1];
                for(int i=0,j=0;i<persions.length;i++){
                    if(i!=me&&j==0){
                        persions2[i]=persions[i];
                    }else if(i!=me&&j==1){
                        persions2[i-1]=persions[i];
                    }else if(i==me&&j!=1){
                        j=1;
                    }
                }
                mPrisoners2 = Arrays.asList(persions2);
                managerPrisoners.set(manager,mPrisoners2);
                mScore.replace(persions[me], score);
                managerScore.set(manager, mScore);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public int take ( int index, int last){//前面的人，剩下的豆子
            return -1;
        }

        @Override
        public void result ( boolean survived){

        }
}

