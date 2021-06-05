package testing.hw;

import org.springframework.web.multipart.MultipartFile;
import testing.Entity.entity_hw6;
import testing.tool_hw6.hw6_read;
import testing.tool_hw6.hw6_write;

import java.io.IOException;
import java.util.List;

public class hw6 {
    int minutes,times;

    public static void main(String[] args) {
        ReadAndWrite();
    }

    public static void ReadAndWrite(){
        // read
        hw6_read Read = new hw6_read();
        Read.repeatedRead("src/main/java/testing/excel/hw6.xlsx",1,2);
        // System.out.println(Read.getList1().get(3).getMinutes());
        List<entity_hw6> list1 = Read.getList1();
        List<entity_hw6> list2 = Read.getList2();
        for (int i=0 ;i<list1.size();i++){
            entity_hw6 temp = list1.get(i);
            boolean bool_boundary = hw6.boundary(temp.getMinutes(),temp.getTimes());
            if(!bool_boundary){
                System.out.println("越界");
                temp.setResult(-1);
            }
            else {
                temp.setResult(hw6.calculation(temp.getMinutes(),temp.getTimes()));
            }
            list1.set(i,temp);
        }
        for (int i=0 ;i<list2.size();i++){
            entity_hw6 temp = list2.get(i);
            boolean bool_boundary = hw6.boundary(temp.getMinutes(),temp.getTimes());
            if(!bool_boundary){
                System.out.println("越界");
                temp.setResult(-1);
            }
            else {
                temp.setResult(hw6.calculation(temp.getMinutes(),temp.getTimes()));
            }

            list2.set(i,temp);
        }
        System.out.println(list2);
        // write
        hw6_write.write(list1,list2,1,2);
    }

    public static List<entity_hw6> ReadAndWrite(int num){
        // read
        hw6_read Read = new hw6_read();
        hw6_read.repeatedRead("src/main/java/testing/excel/hw6.xlsx",num);
        // System.out.println(Read.getList1().get(3).getMinutes());
        List<entity_hw6> list1 = hw6_read.getList1();
        for (int i=0 ;i<list1.size();i++){
            entity_hw6 temp = list1.get(i);
            boolean bool_boundary = hw6.boundary(temp.getMinutes(),temp.getTimes());
            if(!bool_boundary){
                System.out.println("越界");
                temp.setResult(-1);
            }
            else {
                temp.setResult(hw6.calculation(temp.getMinutes(),temp.getTimes()));
            }
            list1.set(i,temp);
        }
        // write
        hw6_write.write(list1,num);
        return list1;
    }

    public static List<entity_hw6> ReadAndWrite(MultipartFile file,int num) throws IOException {
        // read
        List<entity_hw6> list1 = hw6_read.repeatedRead(file,num);
        for (int i=0 ;i<list1.size();i++){
            entity_hw6 temp = list1.get(i);
            boolean bool_boundary = hw6.boundary(temp.getMinutes(),temp.getTimes());
            if(!bool_boundary){
                System.out.println("越界");
                temp.setResult(-1);
            }
            else {
                temp.setResult(hw6.calculation(temp.getMinutes(),temp.getTimes()));
            }
            list1.set(i,temp);
        }
        System.out.println(list1);
        // write
        hw6_write.write(list1,num);
        return list1;
    }

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
        //System.out.println(rate);
        double charge = 25 + minutes*rate*0.15;
        return charge;
    }

}
