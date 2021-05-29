package testing.tool_hw1;

import com.alibaba.excel.EasyExcel;
import testing.Entity.entity_hw1;

import java.util.List;

public class hw1_read {
    private static List<entity_hw1> list1;
    private static List<entity_hw1> list2;

    public static List<entity_hw1> getList1() {
        return list1;
    }

    public static List<entity_hw1> getList2() {
        return list2;
    }



    /**
     * 在使用不同方法进行测试时，需要读取一个excel中国多个sheet，也就是repeatedRead
     */
    public static void repeatedRead(String filename,int sheet1,int sheet2){
        //部分sheet读取
        String fileName = filename;
        List<entity_hw1> temp1 = EasyExcel.read(fileName,
                entity_hw1.class, new DataListener()).sheet(sheet1).doReadSync();
        List<entity_hw1> temp2 = EasyExcel.read(fileName,
                entity_hw1.class, new DataListener()).sheet(sheet2).doReadSync();
        list1 = temp1;
        list2 = temp2;
    }
    //重载  直接传入文件
//    public static List<entity_hw6> repeatedRead(MultipartFile file, int sheet) throws IOException {
//        List<entity_hw6> list = EasyExcel.read(file.getInputStream()
//                , entity_hw6.class, new DataListener()).sheet(sheet).doReadSync();
//        return list;
//    }
}
