package com.jude;

import com.jude.prisoner.*;

import java.util.Map;

public class Main {
    public static final Prisoner[] PRISONERS = {
            new AlexDeemPrisoner(),
            new BlakePrisonerM(),       // Reflect
            new GrantsomePrisoner(),    // Reflect
            new HgsilPrisoner(),        // Reflect
            new HxPrisoner(),
            new JayPrisoner(),          // Reflect
            new NimaPrisoner(),
            new NirioPrisoner(),
            new NookiaPrisoner(),       // Reflect
            new PinkDPrisoner(),        // 搞事
            new Rename(),               // Reflect
            new WcyPrisoner(),
            new XiaossicaPrisoner(),
            new XuanYuPrisoner(),
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
