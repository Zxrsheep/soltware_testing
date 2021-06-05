package testing.hw;

import testing.Entity.entity_hw3;
import testing.Entity.entity_hw6;
import testing.tool_hw3.hw3_read;
import testing.tool_hw3.hw3_write;
import testing.tool_hw6.hw6_read;
import testing.tool_hw6.hw6_write;

import java.util.List;

public class hw3 {

    public static void main(String[] args) {
        ReadAndWrite();
    }

    public static void ReadAndWrite(){
        hw3_read Read = new hw3_read();
        Read.repeatedRead("src/main/java/testing/excel/hw3.xlsx",1,2);
        List<entity_hw3> list1 = Read.getList1();
        List<entity_hw3> list2 = Read.getList2();
        for (int i=0 ;i<list1.size();i++){
            entity_hw3 temp = list1.get(i);
            boolean bool_boundary = hw3.boundary(temp.getDisplays(),temp.getHosts(), temp.getPeripherals());
            if(!bool_boundary){
                System.out.println("越界");
                temp.setResult(-1);
            }
            else {
                temp.setResult(hw3.commission(temp.getDisplays(),temp.getHosts(), temp.getPeripherals()));
            }
            list1.set(i,temp);
        }
        for (int i=0 ;i<list2.size();i++){
            entity_hw3 temp = list2.get(i);
            boolean bool_boundary = hw3.boundary(temp.getDisplays(),temp.getHosts(), temp.getPeripherals());
            if(!bool_boundary){
                System.out.println("越界");
                temp.setResult(-1);
            }
            else {
                temp.setResult(hw3.commission(temp.getDisplays(),temp.getHosts(), temp.getPeripherals()));
            }

            list2.set(i,temp);
        }
        System.out.println(list2);
        // write
        hw3_write.write(list1,list2,1,2);
    }

    public static List<entity_hw3> ReadAndWrite(int num){
        // read
        hw3_read Read = new hw3_read();
        hw3_read.repeatedRead("src/main/java/testing/excel/hw3.xlsx",num);
        // System.out.println(Read.getList1().get(3).getMinutes());
        List<entity_hw3> list1 = hw3_read.getList1();
        for (int i=0 ;i<list1.size();i++){
            entity_hw3 temp = list1.get(i);
            boolean bool_boundary = hw3.boundary(temp.getDisplays(),temp.getHosts(), temp.getPeripherals());
            if(!bool_boundary){
                System.out.println("越界");
                temp.setResult(-1);
            }
            else {
                temp.setResult(hw3.commission(temp.getDisplays(),temp.getHosts(), temp.getPeripherals()));
            }
            list1.set(i,temp);
        }
        // write
        hw3_write.write(list1,num);
        return list1;
    }


    public static boolean boundary(int displays,int hosts,int peripherals){
        if (displays > 0 && hosts > 0 && peripherals > 0 && displays <= 80 && hosts <= 70 && peripherals <= 90 )
            return true;
        else
            return false;
    }

    public static double commission(int displays,int hosts,int peripherals){
        double sum = displays * 30 + hosts * 25 + peripherals * 45;
        double commissions = 0;
        if (sum <= 1000)
            commissions = sum * 0.1;
        else if (sum > 1000 && sum <= 1800)
            commissions = sum * 0.15;
        else if (sum > 1800)
            commissions = sum * 0.2;
        return commissions;
    }



}
