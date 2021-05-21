package testing.hw;


public class hw6 {

    int minutes,times;

    public static boolean boundary(int minutes,int times){
        if (times<0 || times>11)
            return false;
        else if (minutes<0||minutes>44640)
            return false;
        return true;
    }

    public static double Discount_rate(int minutes,int times){
        if(minutes>0&&minutes<=60)
            if (times<=1)
                return 0.01;
        else if (minutes>60&&minutes<=120)
            if (times<=2)
                return 0.015;
        else if (minutes>120&&minutes<=180)
                if (times<=3)
                    return 0.02;
        else if (minutes>180&&minutes<=300)
                    if (times<=3)
                        return 0.025;
        else if (minutes>300)
                        if (times<=6)
                            return 0.03;
        return 0;
    }

    public static double calculation(int minutes,int times){
        double rate = Discount_rate(minutes,times);
        double charge = 25 + minutes*rate;
        return charge;
    }

}
