package com.jude.prisoner;

/**
 * Created by 王晨宇1 on 2016/10/27.
 */
import java.util.Random;
public interface RandomDemo {
    public static void main(String args[]){
        Random a = new Random();
        System.out.println("生死各安天命"+a.nextInt(666));
    }
}
