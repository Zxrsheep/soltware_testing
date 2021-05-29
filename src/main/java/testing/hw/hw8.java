package testing.hw;

import testing.Entity.entity_hw8;
import testing.tool_hw8.hw8_read;
import testing.tool_hw8.hw8_write;

import java.util.List;

public class hw8 {
    static int temp = 0;

    public static void main(String[] args) {
        ReadAndWrite();
    }

    public static void ReadAndWrite(){
        hw8_read Read = new hw8_read();
        Read.repeatedRead("src/main/java/testing/excel/hw8.xlsx",1,2);
        List<entity_hw8> list1 = Read.getList1();
        List<entity_hw8> list2 = Read.getList2();
        for (int i=0 ;i<list1.size();i++){
            entity_hw8 temp = list1.get(i);
            boolean bool_boundary = hw8.boundary(temp.getYear(),temp.getMonth(), temp.getDay());
            if(!bool_boundary){
                System.out.println("越界");
                temp.setResult(-1);
            }
            else {
                temp.setResult(hw8.temp());
            }
            list1.set(i,temp);
        }
        for (int i=0 ;i<list2.size();i++){
            entity_hw8 temp = list2.get(i);
            boolean bool_boundary = hw8.boundary(temp.getYear(),temp.getMonth(), temp.getDay());
            if(!bool_boundary){
                System.out.println("越界");
                temp.setResult(-1);
            }
            else {
                temp.setResult(hw8.temp());
            }

            list2.set(i,temp);
        }
        System.out.println(list2);
        // write
        hw8_write.write(list1,list2,1,2);
    }


    public static boolean boundary(int years, int months, int days){
        boolean isRun = false;
        int totalDays = 0;
        int beforeDays = 0;
        if (years < 1900) {
            return false;
        }
        else{
            if((years % 4 == 0 && years % 100 != 0) || (years % 400 == 0)) {
                isRun = true;
            }
            else
                isRun = false;
            if(months <= 0 || days <= 0 || months > 12 || days > 31) {
                return false;
            }
            else if((months == 4 || months == 6 || months == 9 || months == 11 ) && days > 30 )
                return false;
            else if(isRun == true && months == 2 && days > 29)
                return false;
            else if(isRun == false && months == 2 && days > 28)
                return false;
            else{
                for(int i = 1900; i < years; i++){
                    if((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)){
                        totalDays = totalDays + 366;
                    }else{
                        totalDays = totalDays + 365;
                    }
                }
                for(int j = 1; j <= months; j++){
                    int day = 0;
                    switch(j){
                        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                            day = 31;
                            break; case 4: case 6: case 9: case 11: day = 30;
                            break; case 2: if(isRun){
                            day = 29;
                        }else {
                            day = 28;
                        }
                            //System.out.println(day);
                    }
                    if(j < months){
                        beforeDays = beforeDays + day;
                    }
                }
                totalDays = totalDays + beforeDays + days - 1;
                temp = 1 + totalDays % 7 ;
                return true;
            }

        }
    }
    public static int temp(){
        return temp;
    }



}
