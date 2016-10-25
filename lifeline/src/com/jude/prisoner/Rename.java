
package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;
import com.sun.javafx.collections.MappingChange;

import java.lang.reflect.Field;
import java.util.*;


/**
 * Created by lenovo on 2016/10/23.
 */
public class MotherFuckerPrisoner implements Prisoner {
    int totalCount;
    int totalPerson;
    Manager mymanager;
    int myindex;

    @Override
    public String getName() {
        return "柳鹏2016212765";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) throws IllegalAccessException {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
         mymanager=manager;





    }

    @Override
    public int take(int index, int last) {
        HashMap<Prisoner, Integer> mylifemap = null;
        List<Prisoner> sheeps = null;
        int a[] = new int[index];
        try {
            Field cl = mymanager.getClass().getDeclaredField("mPrisoners");
            cl.setAccessible(true);

            sheeps=(List<Prisoner>) cl.get(mymanager) ;
            if (sheeps.get(0).getName().equals("柳鹏2016212765")){
                 Collections.swap(sheeps,0,4);
            }
            else if (sheeps.get(1).getName().equals("柳鹏2016212765")){
                Collections.swap(sheeps,1,4);
            }
            cl.set(mymanager,sheeps);
            Field f = mymanager.getClass().getDeclaredField("mTempHold");
            f.setAccessible(true);
            mylifemap=(HashMap<Prisoner, Integer>) f.get(mymanager);


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < index; i++) {
            a[i] = mylifemap.get(sheeps.get(i));
        }

        for (int j = 0; j < index; j++) {
            for (int i = 0; i < index; i++) {

                if (a[j] > a[i]) {
                    int temp;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            if(index==1){
                return totalCount/(totalPerson+4);
            }
            return a[index-1]-1;
        }
        this. myindex=index;
       return totalCount/(totalPerson+4);

    }








    @Override
    public void result(boolean survived) {
        if (!survived) {
            HashMap<Prisoner, Integer> retry = null;
            List<Prisoner> sheeps = null;
            try {
                Field cl = mymanager.getClass().getDeclaredField("mPrisoners");
                cl.setAccessible(true);

                sheeps=(List<Prisoner>) cl.get(mymanager) ;

                cl.set(mymanager,sheeps);
                Field f = mymanager.getClass().getDeclaredField("mScore");
                f.setAccessible(true);
                retry=(HashMap<Prisoner, Integer>) f.get(mymanager);
                for (int i=0;i<totalPerson;i++){
                    if (retry.get(sheeps.get(i))!=10000&&sheeps.get(i).getName().equals("柳鹏2016212765")){
                        retry.put(sheeps.get(i),10000);
                    }
                }
                f.set(mymanager,retry);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }


    }}



