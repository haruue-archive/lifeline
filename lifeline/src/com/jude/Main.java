package com.jude;

import com.jude.prisoner.JayPrisoner;
import com.jude.prisoner.NimaPrisoner;
import com.jude.prisoner.ZWPrisoner;

import java.util.Map;

public class Main {
    public static final Prisoner[] PRISONERS = {
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new ZWPrisoner(),
            new JayPrisoner(),
    };


    public static void main(String[] args) {
        //new 一个审判者，把囚徒们和1000颗豆子给他
        Manager manager = new Manager(PRISONERS, 1000);
        //审判1W次
        manager.start(10000);
        System.out.println("\n游戏结束！");//不加这一行我都看不出这是个结果。。。（by.ZW）
        for (Map.Entry<Prisoner, Integer> deciderIntegerEntry : manager.getScore().entrySet()) {
            System.out.println(deciderIntegerEntry.getKey().getName() + "存活了:" + deciderIntegerEntry.getValue() + "次");//这里加了几个字就变得人性化了不是么（by.ZW）
        }

    }

}
