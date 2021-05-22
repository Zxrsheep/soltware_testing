package testing.hw;


import java.util.Scanner;

public class hw6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minutes = scanner.nextInt();
        int times = scanner.nextInt();
        boolean bool_boundary = hw6.boundary(minutes,times);
        if(!bool_boundary)
            System.out.println("越界");
        double charge = hw6.calculation(minutes,times);
        System.out.println(charge);
    }

    int minutes,times;

    public static boolean boundary(int minutes,int times){
        if (times<0 || times>11)
            return false;
        else if (minutes<0||minutes>44640)
            return false;
        return true;
    }

    public static double Discount_rate(int minutes,int times){
        if(minutes>0&&minutes<=60){
            if (times<=1)
                return 0.99;
        }
        else if (minutes>60&&minutes<=120){
            if (times<=2)
                return 0.985;
        }

        else if (minutes>120&&minutes<=180){
            if (times<=3)
                return 0.98;
        }
        else if (minutes>180&&minutes<=300){
            if (times<=3)
                return 0.975;
        }
        else if (minutes>300){
            if (times<=6)
                return 0.97;
        }

        return 1;
    }

    public static double calculation(int minutes,int times){
        double rate = Discount_rate(minutes,times);
        System.out.println(rate);
        double charge = 25 + minutes*rate*0.15;
        return charge;
    }

}
