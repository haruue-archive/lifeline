/**
 * Created by lenovo on 2016/9/24.
 */
public class Time {
   private int year;
     private   int month;
    private int day;
   private int hour;
   private int minute;
   private int second;



    Time(int timestamp) {
        int d, e = 0;

        this.second = timestamp % 60;
        this.minute = (timestamp - second) % 3600 / 60;
        this.hour = (timestamp - second - minute) % 86400 / 3600 + 8;
        d = timestamp / 3600 / 24;


        e = d % 1461;
        while (e >= 365)
            e = e - 365;
        if (e < 31)
            this.month = 1;
        else if (e < 59)
            this.month = 2;
        else if (e < 90)
            this.month = 3;
        else if (e < 120)
            this.month = 4;
        else if (e < 151)
            this.month = 5;
        else if (e < 181)
            this.month = 6;
        else if (e < 212)
            this.month = 7;
        else if (e < 243)
            this.month = 8;
        else if (e < 273)
            this.month = 9;
        else if (e < 304)
            this.month = 10;
        else if (e < 334)
            this.month = 11;
        else if (e<365)
            this.month = 12;
        else if (e<31&&this.year%4==0)
            this.month=1;
        else if (e<60&&this.year%4==0)
            this.month=2;
        else if (e<911&&this.year%4==0)
            this.month=3;
        else if (e<121&&this.year%4==0)
            this.month=4;
        else if (e<152&&this.year%4==0)
            this.month=5;
        else if (e<182&&this.year%4==0)
            this.month=6;
        else if (e<213&&this.year%4==0)
            this.month=7;
        else if(e<244&&this.year%4==0)
            this.month=8;
        else if(e<274&&this.year%4==0)
            this.month=9;
        else if (e<305&&this.year%4==0)
            this.month=10;
        else if (e<335&&this.year%4==0)
            this.month=11;
        else if (e<366&&this.year%4==0)
            this.month=12;
        if (e < 31)
            this.day = e;
        else if (e < 59)
            this.day = e - 31;
        else if (e < 90)
            this.day = e - 59;
        else if (e < 120)
            this.day = e - 90;
        else if (e < 151)
            this.day = e - 120;
        else if (e < 181)
            this.day = e - 151;
        else if (e < 212)
            this.day = e - 181;
        else if (e < 243)
            this.day = e - 212;
        else if (e < 273)
            this.day = e - 243;
        else if (e < 304)
            this.day = e - 273;
        else if (e < 334)
            this.day = e - 304;
        else if (e<365)
            this.day = e - 334;
        else if (e<60&&this.year%4==0)
            this.day=e-31;
        else if (e<91&&this.year%4==0)
            this.day=e-60;
        else if (e<121&&this.year%4==0)
            this.day=e-91;
        else if (e<152&&this.year%4==0)
            this.day=e-121;
        else if (e<182&&this.year%4==0)
            this.day=e-152;
        else if (e<213&&this.year%4==0)
            this.day=e-182;
        else if(e<244&&this.year%4==0)
            this.day=e-213;
        else if(e<274&&this.year%4==0)
            this.day=e-244;
        else if (e<305&&this.year%4==0)
            this.day=e-274;
        else if (e<335&&this.year%4==0)
            this.day=e-305;
        else if(e<366&&this.year%4==0)
            this.day=e-336;
        if (e==0)
            e=e+1;
        this.year = (d - this.day) / 365 + 1970;
        if (this.hour==24)
            this.day=this.day+1;
        if (this.hour==24)
            this.hour=0;

            }




   Time(int timestamp, String timezone) {
        this(timestamp);
        switch (timezone) {
            case ("北京"):

                break;
            case ("东京"):
                this.hour = this.hour + 1;
                if (this.hour > 24)
                    this.hour = this.hour - 24;
                if (this.hour > 24) this.day = this.day + 1;



                break;
            case ("关岛"):
                this.hour = this.hour + 2;
                if (this.hour > 24)
                    this.hour = this.hour - 24;
                if (this.hour > 24) this.day = this.day + 1;

                break;
            case ("所罗门群岛"):
                this.hour = this.hour + 3;
                if (this.hour > 24)
                    this.hour = this.hour - 24;
                if (this.hour > 24) this.day = this.day + 1;

                break;
            case ("惠灵顿"):
                this.hour = this.hour + 4;
                if (this.hour > 24)
                    this.hour = this.hour - 24;
                if (this.hour > 24)
                    this.day = this.day + 1;

                break;

            case ("曼谷"):
                this.hour = this.hour - 1;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;


            case ("新疆"):
                this.hour = this.hour - 2;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;


            case ("伊斯兰堡"):
                this.hour = this.hour - 3;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;

            case ("阿联酋"):
                this.hour = this.hour - 4;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;


            case ("莫斯科"):
                this.hour = this.hour - 5;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;


            case ("开罗"):
                this.hour = this.hour - 6;
                if (this.hour < 0) ;
                this.hour = this.hour + 24;
                if (this.hour < 0) ;
                this.day = this.day - 1;

                break;


            case ("伦敦"):
                this.hour = this.hour - 7;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;

            case ("非洲"):
                this.hour = this.hour - 8;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;


            case ("大西洋中部"):
                this.hour = this.hour - 9;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;


            case ("巴西"):
                this.hour = this.hour - 10;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;


            case ("圣地亚哥"):
                this.hour = this.hour - 11;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;

            case ("纽约"):
                this.hour = this.hour - 12;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;


            case ("芝加哥"):
                this.hour = this.hour - 13;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;

            case ("菲尼克斯"):
                this.hour = this.hour - 14;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;


            case ("加利福利亚"):
                this.hour = this.hour - 15;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;


            case ("阿拉斯加"):
                this.hour = this.hour - 16;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;
            case ("西十一区"):
                this.hour = this.hour - 17;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;


            case ("西十二区"):
                this.hour = this.hour - 18;
                if (this.hour < 0)
                    this.hour = this.hour + 24;
                if (this.hour < 0)
                    this.day = this.day - 1;

                break;

        }

    }

    public Time(int timestamp, String timezone, int y, int mon, int d, int h, int min, int s) {
        this(timestamp);
        if (y > this.year)
            y = y - this.year;
        else
            y = this.year - y;
        if (mon > this.month)
            mon = mon - this.month;
        else
            mon = this.month - mon;
        if (d > this.day)
            d = d - this.day;
        else
            d = this.day - d;
        if (h > this.hour)
            h = h - this.hour;
        else
            h = this.hour - h;
        if (min > this.minute)
            min = min - this.minute;
        else
            min = this.minute - min;
        if (s > this.second)
            s = s - this.second;
        else
            s = this.second - s;
        System.out.println("差了" + y + "年" + mon + "月" + d + "天" + h + "小时" + min + "分钟" + s + "秒");
    }


           Time(int timestamp, String timezone, int second) {
        this(timestamp);
        int a, b,c,d,e,f,x,y,g=0;
        g=timestamp+second;
        a=g%60;
        b=(g-a)%3600/60;
        c=(g-a-b)%86400/3600+8;
        d=g/3600/24;

        e=d%1461;

        while(e>=365)
            e=e-365;
               y =(d-e)/365+1970;
        if (e<31)
            f=1;
        else if (e<59)
            f=2;
        else if (e<90)
            f=3;
        else if (e<120)
            f=4;
        else if (e<151)
            f=5;
        else if (e<181)
            f=6;
        else if (e<212)
            f=7;
        else if(e<243)
            f=8;
        else if(e<273)
            f=9;
        else if (e<304)
            f=10;
        else if (e<334)
            f=11;
        else if (e<365)
            f=12;
              else if (e<31&&y%4==0)
                   f=1;
               else if (e<60&&y%4==0)
                   f=2;
               else if (e<911&&y%4==0)
                   f=3;
               else if (e<121&&y%4==0)
                   f=4;
               else if (e<152&&y%4==0)
                   f=5;
               else if (e<182&&y%4==0)
                   f=6;
               else if (e<213&&y%4==0)
                   f=7;
               else if(e<244&&y%4==0)
                   f=8;
               else if(e<274&&y%4==0)
                   f=9;
               else if (e<305&&y%4==0)
                   f=10;
               else if (e<335&&y%4==0)
                   f=11;
               else if (e<366)
                   f=12;
        if (e<31)
            e=e;
        else if (e<59)
            e=e-31;
        else if (e<90)
            e=e-59;
        else if (e<120)
            e=e-90;
        else if (e<151)
            e=e-120;
        else if (e<181)
            e=e-151;
        else if (e<212)
            e=e-181;
        else if(e<243)
            e=e-212;
        else if(e<273)
            e=e-243;
        else if (e<304)
            e=e-273;
        else if (e<334)
            e=e-304;
        else if (e<365)
            e=e-334;
               else if (e<60&&y%4==0)
                   e=e-31;
               else if (e<91&&y%4==0)
                   e=e-60;
               else if (e<121&&y%4==0)
                   e=e-91;
               else if (e<152&&y%4==0)
                   e=e-121;
               else if (e<182&&y%4==0)
                   e=e-152;
               else if (e<213&&y%4==0)
                   e=e-182;
               else if(e<244&&y%4==0)
                   e=e-213;
               else if(e<274&&y%4==0)
                   e=e-244;
               else if (e<305&&y%4==0)
                   e=e-274;
               else if (e<335&&y%4==0)
                   e=e-305;
               else if(e<366&&y%4==0)
                   e=e-336;
               if (e==0)
                   e=e+1;
               e=this.day;
               y=this.year;
               f=this.month;
               a=this.second;
               b=this.minute;
               c=this.hour;





           }



    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {

        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {

        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {

        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {

        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {

        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}




























