package com.jude;

import com.jude.prisoner.HxPrisoner;
import com.jude.prisoner.JayPrisoner;
import com.jude.prisoner.NimaPrisoner;
import com.jude.prisoner.ZhangPrisoner;

import java.util.Map;

public class Main {
    public static final Prisoner[] PRISONERS = {
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new NimaPrisoner(),
            new JayPrisoner(),
            new ZhangPrisoner(),
    };


    public static void main(String[] args) {
        //new 一个审判者，把囚徒们和1000颗豆子给他
        Manager manager = new Manager(PRISONERS,1000);
        //审判1W次
        manager.start(10000);
        for (Map.Entry<Prisoner, Integer> deciderIntegerEntry : manager.getScore().entrySet()) {
            System.out.println(deciderIntegerEntry.getKey().getName()+":"+deciderIntegerEntry.getValue());
        }
    }

}
