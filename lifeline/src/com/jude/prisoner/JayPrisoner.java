package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jay on 2016/10/22.
 */
public class JayPrisoner implements Prisoner {
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

        try {
            Field f = cl.getDeclaredField("mPrisoners");
            f.setAccessible(true);
            prisoners = (List<Prisoner>) f.get(mManager);

            f = cl.getDeclaredField("mTempHold");
            f.setAccessible(true);
            tempHold = (HashMap<Prisoner, Integer>) f.get(mManager);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        if (index != mTotalPrisoner - 1) {
            Prisoner a = prisoners.get(index);
            Prisoner b = prisoners.get(mTotalPrisoner - 1);
            prisoners.set(index, b);
            prisoners.set(mTotalPrisoner - 1, a);
            return -1;
        } else {
            int[] bean = new int[index];

            for (int i = 0; i < mTotalPrisoner - 2; i++)
                bean[i] = tempHold.get(prisoners.get(i));

            Arrays.sort(bean);

            for (int i = 0; i < bean.length - 1; i++) {
                if (bean[i] <= 0)
                    continue;

                if (bean[i + 1] - bean[i] > 1)
                    return bean[i] + 1;
            }

            for (int i = 0; i < mTotalPrisoner - 2; i++)
                tempHold.replace(prisoners.get(i), i * 2);
            return 3;
        }
    }

    @Override
    public void result(boolean survived) {
        if (!survived)
        {
            HashMap<Prisoner, Integer> score = null;

            Class cl = mManager.getClass();
            Field f = null;
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
            score.replace(this,n + 1);
        }
    }
}
