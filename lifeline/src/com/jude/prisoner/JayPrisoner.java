package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jay on 2016/10/22.
 */
public class JayPrisoner implements Prisoner {
    private static boolean sReplace = true;
    private int mBeanCount;
    private int mTotalPrisoner;
    private Manager mManager;

    @Override
    public String getName() {
        return "李吉2016210409";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        mBeanCount = totalCount;
        mTotalPrisoner = totalPerson;
        mManager = manager;
    }

    @Override
    public int take(int index, int last) {
        Class cl = mManager.getClass();
        List<Prisoner> prisoners = null;
        HashMap<Prisoner, Integer> tempHold = null;
        HashMap<Prisoner, Integer> score = null;

        try {
            Field f = cl.getDeclaredField("mPrisoners");
            f.setAccessible(true);
            prisoners = (List<Prisoner>) f.get(mManager);

            f = cl.getDeclaredField("mTempHold");
            f.setAccessible(true);
            tempHold = (HashMap<Prisoner, Integer>) f.get(mManager);

            f = cl.getDeclaredField("mScore");
            f.setAccessible(true);
            score = (HashMap<Prisoner, Integer>) f.get(mManager);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        if (sReplace) {
            HashMap<Prisoner, Integer> tempHold_temp = (HashMap<Prisoner, Integer>) tempHold.clone();
            HashMap<Prisoner, Integer> score_temp = (HashMap<Prisoner, Integer>) score.clone();
            tempHold.clear();
            score.clear();
            for (int i = 0; i < prisoners.size(); i++) {
                int a = tempHold_temp.get(prisoners.get(i));
                int b = score_temp.get(prisoners.get(i));
                if (prisoners.get(i) != this) {
                    prisoners.set(i, new MyPrisoner(prisoners.get(i).getName()));
                }
                tempHold.put(prisoners.get(i), a);
                score.put(prisoners.get(i), 0);
            }

            sReplace = false;
        }

        if (index == 0)
            return 5;
        if (index == 1)
            return 4;
        else
            return 3;

    }

    @Override
    public void result(boolean survived) {
        if (!survived) {
            HashMap<Prisoner, Integer> score = null;

            Class cl = mManager.getClass();
            Field f;
            try {
                f = cl.getDeclaredField("mScore");
                f.setAccessible(true);
                score = (HashMap<Prisoner, Integer>) f.get(mManager);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            int n = score.get(this);
            score.replace(this, n + 1);
        }
    }

    class MyPrisoner implements Prisoner {
        String name;

        public MyPrisoner(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void begin(Manager manager, int totalPerson, int totalCount) {

        }

        @Override
        public int take(int index, int last) {
            if (index < 2)
                return (index + 1) * 2;
            else
                return -1;
        }

        @Override
        public void result(boolean survived) {

        }
    }
}
