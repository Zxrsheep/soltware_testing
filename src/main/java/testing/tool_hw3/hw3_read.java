package testing.tool_hw3;

import com.alibaba.excel.EasyExcel;
import org.springframework.web.multipart.MultipartFile;
import testing.Entity.entity_hw3;
import testing.Entity.entity_hw6;
import testing.tool_hw6.hw6_read;

import java.io.IOException;
import java.util.List;

public class hw3_read {
    private static List<entity_hw3> list1;
    private static List<entity_hw3> list2;

    public static List<entity_hw3> getList1() {
        return list1;
    }

    public static void setList1(List<entity_hw3> list1) {
        hw3_read.list1 = list1;
    }

    public static List<entity_hw3> getList2() {
        return list2;
    }

    public static void setList2(List<entity_hw3> list2) {
        hw3_read.list2 = list2;
    }



    /**
     * 在使用不同方法进行测试时，需要读取一个excel中国多个sheet，也就是repeatedRead
     */
    public static void repeatedRead(String filename,int sheet1,int sheet2){
        //部分sheet读取
        String fileName = filename;
        List<entity_hw3> temp1 = EasyExcel.read(fileName,
                entity_hw3.class, new DataListener()).sheet(sheet1).doReadSync();
        List<entity_hw3> temp2 = EasyExcel.read(fileName,
                entity_hw3.class, new DataListener()).sheet(sheet2).doReadSync();
        list1 = temp1;
        list2 = temp2;
    }
    //重载  直接传入文件
    public static void repeatedRead(String filename,int sheet1){
        //部分sheet读取
        String fileName = filename;
        List<entity_hw3> temp1 = EasyExcel.read(fileName,
                entity_hw3.class, new DataListener()).sheet(sheet1).doReadSync();
        list1 = temp1;
    }
    //重载  直接传入文件
    public static List<entity_hw3> repeatedRead(MultipartFile file, int sheet) throws IOException {
        List<entity_hw3> list = EasyExcel.read(file.getInputStream()
                , entity_hw3.class, new DataListener()).sheet(sheet).doReadSync();
        return list;
    }
}
