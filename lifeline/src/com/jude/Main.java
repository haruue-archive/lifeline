package com.jude;

import com.jude.prisoner.*;

import java.util.Map;

public class Main {
    public static final Prisoner[] PRISONERS = {
            new JayPrisoner(),      // Reflect
            new NimaPrisoner(),
            new NookiaPrisoner(),   // Reflect
            new Rename(),           // Reflect
            new ZhangPrisoner(),
            new BlakePrisonerM(),
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
