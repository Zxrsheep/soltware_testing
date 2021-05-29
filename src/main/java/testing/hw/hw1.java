package testing.hw;

import testing.Entity.entity_hw1;
import testing.tool_hw1.hw1_read;
import testing.tool_hw1.hw1_write;

import java.util.List;
import java.util.Scanner;

public class hw1 {

    public static void main(String[] args) {
        ReadAndWrite();
    }

    public static void ReadAndWrite(){
        hw1_read Read = new hw1_read();
        Read.repeatedRead("src/main/java/testing/excel/hw1.xlsx",1,2);
        List<entity_hw1> list1 = Read.getList1();
        List<entity_hw1> list2 = Read.getList2();
        for (int i=0 ;i<list1.size();i++){
            entity_hw1 temp = list1.get(i);
            boolean bool_boundary = hw1.boundary(temp.geta(),temp.getb(), temp.getc());
            if(!bool_boundary){
                System.out.println("越界");
                temp.setResult(null);
            }
            else {
                temp.setResult(result(hw1.type(temp.geta(),temp.getb(), temp.getc())));
            }
            list1.set(i,temp);
        }
        for (int i=0 ;i<list2.size();i++){
            entity_hw1 temp = list2.get(i);
            boolean bool_boundary = hw1.boundary(temp.geta(),temp.getb(), temp.getc());
            if(!bool_boundary){
                System.out.println("越界");
                temp.setResult(null);
            }
            else {
                temp.setResult(result(hw1.type(temp.geta(),temp.getb(), temp.getc())));
            }

            list2.set(i,temp);
        }
        System.out.println(list2);
        // write
        hw1_write.write(list1,list2,1,2);
    }


    public static boolean boundary(int a,int b,int c){
        if(a <= 0 || b <= 0 || c <= 0)
            return false;
        else
            return true;
    }

    public static String result(int a){
        switch (a){
            case 1:
                return "直角三角形";
            case 2:
                return "等边三角形";
            case 3:
                return "等腰锐角三角形";
            case 4:
                return "等腰钝角三角形";
            case 5:
                return "等腰直角三角形";
            case 6:
                return "非等腰锐角三角形";
            case 7:
                return "非等腰钝角三角形";
        }
        return null;
    }

    /*
    判断三角形类型
     */
    public static int type(int a,int b,int c) {
        if( c < b ){
            int temp;
            temp = c;
            c = b;
            b = temp;
        }
        if( c < a ){
            int temp;
            temp = a;
            a = c;
            c = temp;
        }
        int aa = a * a;
        int bb = b * b;
        int cc = c * c;
        System.out.println(aa);
        System.out.println(bb);
        System.out.println(cc);
        boolean equal = false;
        if (a == b || c == b || a == c)
            equal = true;
        System.out.println(equal);
        if(cc == aa + bb && equal == false){
            System.out.println("直角三角形");
            return 1;
        }else if(aa == bb && aa == cc){
            System.out.println("等边三角形");
            return 2;
        }else if(aa + bb > cc && equal == true){
            System.out.println("等腰锐角三角形");
            return 3;
        }else if(aa + bb < cc && equal == true){
            System.out.println("等腰钝角三角形");
            return 4;
        }else if(aa + bb == cc && equal == true){
            System.out.println("等腰直角三角形");
            return 5;
        }else if(aa + bb > cc && equal == false){
            System.out.println("非等腰锐角三角形");
            return 6;
        }else if(aa + bb < cc && equal == false){
            System.out.println("非等腰钝角三角形");
            return 7;
        }
        return 0;
    }



}
