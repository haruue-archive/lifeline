
import java.util.Random;


/**
 * Created by lenovo on 2016/10/9.
 */
public class Poker {
    public String point;
    public String suit;
    public Poker[] pokers;
    public int points;
    private boolean compare;

    private Poker(String point, String suit, int points, int compare) {
        this.point = point;
        this.suit = suit;
        this.points = points;

    }

    public Poker() {
        Poker fishing[] = new Poker[52];
        int a = 0;

        String suit[] = {"Hearts", "Spade", "Dimond", "Club"};
        String point[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int points[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int compare[] = {1, 2, 3, 4};
        for (int b = 0; b < 4; b++) {
            for (int i = 0; i < 13; i++) {
                fishing[a++] = new Poker(point[i], suit[b], points[i], compare[b]);
            }
        }
        pokers = fishing;

    }


    public void shuffle() {
        Poker flash[] = new Poker[26];
        Poker flash2[] = new Poker[26];
        Poker new1[] = new Poker[52];
        for (int i = 0; i < 26; i++) {
            flash[i] = pokers[i];
        }
        for (int g = 26; g < 52; g++) {
            flash2[g - 26] = pokers[g];
        }

        for (int c = 0; c < 26; c++) {
            int b = 2 * c;
            pokers[b] = flash[c];
            int x = 2 * c + 1;
            pokers[x] = flash2[c];
        }//*交叉洗牌

        for (int i = 51; i > 1; i--) {
            int len = i - 1;
            Random ran = new Random();
            int arriDx = ran.nextInt(len);

            Poker po = pokers[i];
            pokers[i] = pokers[arriDx];
            pokers[arriDx] = po;


        }//*第二种算法

        Poker desk[] = new Poker[5];
        desk[0] = pokers[4];
        desk[1] = pokers[5];
        desk[2] = pokers[6];
        desk[3] = pokers[7];
        desk[4] = pokers[8];
        Poker desk2[] = new Poker[5];
        desk2[0] = pokers[9];
        desk2[1] = pokers[10];
        desk2[2] = pokers[11];
        desk2[3] = pokers[12];
        desk2[4] = pokers[13];//*发牌
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                if (desk[i].points > desk[j].points) {
                    Poker po = desk[i];
                    desk[i] = desk[j];
                    desk[j] = po;

                }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                if (desk2[i].points > desk2[j].points) {
                    Poker po = desk2[i];
                    desk2[i] = desk2[j];
                    desk2[j] = po;

                }
        }
        System.out.println("玩家1的手牌是：");
        for (int i = 0; i < 5; i++) {
            System.out.println(desk[i].suit + "\t" + desk[i].point);
        }
        System.out.println("玩家2的手牌是：");
        for (int i = 0; i < 5; i++) {
            System.out.println(desk2[i].suit + "\t" + desk2[i].point);
        }
        int po[] = new int[4];
        po[0] = desk[0].points - desk[1].points;
        po[1] = desk[1].points - desk[2].points;
        po[2] = desk[2].points - desk[3].points;
        po[3] = desk[3].points - desk[4].points;
        int po1[] = new int[4];
        po1[0] = desk2[0].points - desk2[1].points;
        po1[1] = desk2[1].points - desk2[2].points;
        po1[2] = desk2[2].points - desk2[3].points;
        po1[3] = desk2[3].points - desk2[4].points;

        String pokerstyle1;
        int x = 0;
        String pokerstyle;
        String pokerstyle2;
        if(desk[1].suit.equals(desk[0].suit) && desk[1].suit.equals(desk[2].suit) && desk[2].suit.equals(desk[3].suit) &&
                desk[3].suit.equals(desk[4].suit)&&po[1] == 1 && po[2] == 1 && po[3] == 1 && po[4] == 1){
            x = x + 9;
            pokerstyle1 = "X";
            pokerstyle = "同花顺";

        }
        else if (po[0] == 0 && po[1] == 0 && po[2] == 0) {
            x = x + 8;
            pokerstyle1 = "A";
            pokerstyle = "四条";
        } else if (po[1] == 0 && po[2] == 0 && po[3] == 0) {
            x = x + 8;
            pokerstyle1 = "B";
            pokerstyle = "四条";
        } else if (po[3] == 0 && po[1] == 0 && po[0] == 0) {
            x = x + 6;
            pokerstyle1 = "C";
            pokerstyle = "葫芦";
        } else if (po[3] == 0 && po[2] == 0 && po[0] == 0) {
            x = x + 6;
            pokerstyle1 = "D";
            pokerstyle = "葫芦";
        } else if (desk[1].suit.equals(desk[0].suit) && desk[1].suit.equals(desk[2].suit) && desk[2].suit.equals(desk[3].suit) &&
                desk[3].suit.equals(desk[4].suit)) {
            x = x + 5;
            pokerstyle1 = "E";
            pokerstyle = "同花";

        }
        if (po[0] == 1 && po[1] == 1 && po[2] == 1 && po[3] == 1) {
            x = x + 4;
            pokerstyle1 = "F";
            pokerstyle = "顺子";


        } else if (po[0] == 0 && po[1] == 0 && po[2] != 0 && po[3] != 0) {
            x = x + 3;
            pokerstyle1 = "G";
            pokerstyle = "三条";
        } else if (po[1] == 0 && po[2] == 0 && po[0] != 0 && po[3] != 0) {
            x = x + 3;
            pokerstyle1 = "H";
            pokerstyle = "三条";
        } else if (po[1] != 0 && po[2] == 0 && po[0] != 0 && po[3] == 0) {
            x = x + 3;
            pokerstyle1 = "I";
            pokerstyle = "三条";
        } else if (po[1] == 0 && po[2] != 0 && po[0] != 0 && po[3] == 0) {
            x = x + 2;
            pokerstyle1 = "J";
            pokerstyle = "两对";
        } else if (po[1] != 0 && po[2] == 0 && po[0] == 0 && po[3] != 0) {
            x = x + 2;
            pokerstyle1 = "K";
            pokerstyle = "两对";
        } else if (po[1] != 0 && po[2] != 0 && po[0] == 0 && po[3] != 0) {
            x = x + 1;
            pokerstyle1 = "L";
            pokerstyle = "一对";
        } else if (po[2] != 0 && po[0] != 0 && po[3] != 0 && po[1] == 0) {
            x = x + 1;
            pokerstyle1 = "M";
            pokerstyle = "一对";
        } else if (po[0] != 0 && po[1] != 0 && po[3] != 0 && po[2] == 0) {
            x = x + 1;
            pokerstyle1 = "N";
            pokerstyle = "一对";
        } else if (po[2] != 0 && po[1] != 0 && po[3] == 0 && po[0] != 0) {
            x = x + 1;
            pokerstyle1 = "O";
            pokerstyle = "一对";
        } else {
            x = x;
            pokerstyle1 = "P";
            pokerstyle = "高牌";
        }//*判断玩家1的牌型

        int y = 0;

        if (po1[0] == 0 && po1[1] == 0 && po1[2] == 0) {
            y = y + 8;
            pokerstyle2 = "A";
        } else if (po1[1] == 0 && po1[2] == 0 && po1[3] == 0) {
            y = y + 8;
            pokerstyle2 = "B";
        } else if (po1[3] == 0 && po1[1] == 0 && po1[0] == 0) {
            y = y + 6;
            pokerstyle2 = "C";
        } else if (po1[3] == 0 && po1[2] == 0 && po1[0] == 0) {
            y = y + 6;
            pokerstyle2 = "D";
        } else if (desk2[1].suit.equals(desk2[0].suit) && desk2[1].suit.equals(desk2[2].suit) && desk2[2].suit.equals(desk2[3].suit) &&
                desk2[3].suit.equals(desk2[4].suit)) {
            y = y + 5;
            pokerstyle2 = "E";

        }
        if (po1[0] == 1 && po1[1] == 1 && po1[2] == 1 && po1[3] == 1) {
            y = y + 4;
            pokerstyle2 = "F";


        } else if (po1[0] == 0 && po1[1] == 0 && po1[2] != 0 && po1[3] != 0) {
            y = y + 3;
            pokerstyle2 = "G";
        } else if (po1[1] == 0 && po1[2] == 0 && po1[0] != 0 && po1[3] != 0) {
            y = y + 3;
            pokerstyle2 = "H";
        } else if (po1[1] != 0 && po1[2] == 0 && po1[0] != 0 && po1[3] == 0) {
            y = y + 3;
            pokerstyle2 = "I";
        } else if (po1[1] == 0 && po1[2] != 0 && po1[0] != 0 && po1[3] == 0) {
            y = y + 2;
            pokerstyle2 = "J";
        } else if (po1[1] != 0 && po1[2] == 0 && po1[0] == 0 && po1[3] != 0) {
            y = y + 2;
            pokerstyle2 = "K";
        } else if (po1[1] != 0 && po1[2] != 0 && po1[0] == 0 && po1[3] != 0) {
            y = y + 1;
            pokerstyle2 = "L";
        } else if (po1[2] != 0 && po1[0] != 0 && po1[3] != 0 && po1[1] == 0) {
            y = y + 1;
            pokerstyle2 = "M";
        } else if (po1[0] != 0 && po1[1] != 0 && po1[3] != 0 && po1[2] == 0) {
            y = y + 1;
            pokerstyle2 = "N";
        } else if (po1[2] != 0 && po1[1] != 0 && po1[3] == 0 && po1[0] != 0) {
            y = y + 1;
            pokerstyle2 = "O";
        } else {
            y = y;
            pokerstyle2 = "P";
        }//*判断2的牌型并标号

        int poe = desk[0].points + desk[1].points + desk[2].points + desk[3].points + desk[4].points;
        int poe2 = desk2[0].points + desk2[1].points + desk2[2].points + desk2[3].points + desk2[4].points;
        if (x > y) {
            System.out.println("玩家1胜利");

        } else if (x < y) {
            System.out.println("玩家2胜利");
        }
        if (x == y) {
            if (pokerstyle1.equals("四条")) {
                if (desk[2].points > desk2[2].points) {
                    System.out.println("玩家1胜利");
                } else if (desk[2].points < desk2[2].points) {
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle.equals("同花顺")){ if (desk[0].points > desk2[0].points) {
                    System.out.println("玩家1胜利");
                } else if (desk[0].points < desk2[0].points) {
                    System.out.println("玩家2胜利");

                }
            }} else if (pokerstyle.equals("葫芦")) {
                if (desk[2].points > desk2[2].points) {
                    System.out.println("玩家1胜利");
                } else if (desk[2].points < desk2[2].points) {
                    System.out.println("玩家2胜利");
                }

            } else if (pokerstyle.equals("同花")) {
                if (poe > poe2) {
                    System.out.println("玩家1胜利");
                } else if (desk[2].points > desk2[2].points) {
                    System.out.println("玩家2胜利");
                }
            } else if (pokerstyle.equals("顺子")) {
                if (desk[0].points > desk2[0].points) {
                    System.out.println("玩家1胜利");
                } else if (desk[0].points < desk2[0].points) {
                    System.out.println("玩家2胜利");
                }

            } else if (pokerstyle.equals("三条")) {
                if (desk[2].points > desk2[2].points) {
                    System.out.println("玩家1胜利");
                } else if (desk[2].points < desk2[2].points) {
                    System.out.println("玩家2胜利");
                }
            }
            else if (pokerstyle.equals("两对")) {
                if (desk[1].points > desk2[1].points) {
                    System.out.println("玩家1胜利");
                } else if (desk[1].points < desk2[1].points) {
                    System.out.println("玩家2胜利");
                }
            }
            else if (pokerstyle.equals("一对")){
                if(pokerstyle1.equals("L")&&pokerstyle2.equals("L")&&desk[0].points>desk2[0].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("L")&&pokerstyle2.equals("L")&&desk[0].points<desk2[0].points){
                    System.out.println("玩家2胜利");
                }
               else if(pokerstyle1.equals("M")&&pokerstyle2.equals("M")&&desk[1].points>desk2[1].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("M")&&pokerstyle2.equals("M")&&desk[1].points<desk2[1].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("N")&&pokerstyle2.equals("N")&&desk[2].points>desk2[2].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("N")&&pokerstyle2.equals("N")&&desk[2].points<desk2[2].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("O")&&pokerstyle2.equals("O")&&desk[3].points>desk2[3].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("O")&&pokerstyle2.equals("O")&&desk[3].points<desk2[3].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("L")&&pokerstyle2.equals("M")&&desk[1].points>desk2[1].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("L")&&pokerstyle2.equals("M")&&desk[1].points<desk2[1].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("L")&&pokerstyle2.equals("N")&&desk[0].points>desk2[2].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("L")&&pokerstyle2.equals("N")&&desk[0].points<desk2[2].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("L")&&pokerstyle2.equals("O")&&desk[0].points>desk2[3].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("L")&&pokerstyle2.equals("O")&&desk[0].points<desk2[3].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("M")&&pokerstyle2.equals("L")&&desk[1].points>desk2[0].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("M")&&pokerstyle2.equals("L")&&desk[1].points<desk2[0].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("M")&&pokerstyle2.equals("N")&&desk[1].points>desk2[2].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("M")&&pokerstyle2.equals("N")&&desk[1].points<desk2[2].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("M")&&pokerstyle2.equals("O")&&desk[1].points>desk2[3].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("M")&&pokerstyle2.equals("O")&&desk[1].points<desk2[3].points){
                    System.out.println("玩家2胜利");
                } else if(pokerstyle1.equals("N")&&pokerstyle2.equals("L")&&desk[3].points>desk2[0].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("N")&&pokerstyle2.equals("L")&&desk[3].points<desk2[0].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("N")&&pokerstyle2.equals("M")&&desk[2].points>desk2[2].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("N")&&pokerstyle2.equals("M")&&desk[2].points<desk2[2].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("N")&&pokerstyle2.equals("O")&&desk[2].points>desk2[3].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("N")&&pokerstyle2.equals("O")&&desk[2].points<desk2[3].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("O")&&pokerstyle2.equals("N")&&desk[3].points>desk2[3].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("O")&&pokerstyle2.equals("N")&&desk[3].points<desk2[3].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("O")&&pokerstyle2.equals("M")&&desk[3].points>desk2[2].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("O")&&pokerstyle2.equals("M")&&desk[3].points<desk2[2].points){
                    System.out.println("玩家2胜利");
                }
                else if(pokerstyle1.equals("O")&&pokerstyle2.equals("L")&&desk[3].points>desk2[0].points){
                    System.out.println("玩家1胜利");
                }
                else if (pokerstyle1.equals("O")&&pokerstyle2.equals("L")&&desk[3].points<desk2[0].points){
                    System.out.println("玩家2胜利");
                }


            }
            else if(pokerstyle.equals("高牌")) {
                if (desk[0].points > desk2[0].points)
                {
                    System.out.println("玩家1胜利");

                }
               else if (desk[0].points < desk2[0].points)
                {
                    System.out.println("玩家2胜利");

                }
                else if (desk[0].points == desk2[0].points)
                {
                    System.out.println("平局");

                }}
        }

    }}






