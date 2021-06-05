package testing.tool_hw8;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import testing.Entity.entity_hw6;
import testing.Entity.entity_hw8;

import java.util.List;

public class hw8_write {

    public static void write(List<entity_hw8> list1, List<entity_hw8> list2 , int num1, int num2) {
        String fileName = "src/main/java/testing/excel/" + "hw8_result.xlsx";
        ExcelWriter excelWriter = null;
        try {
            // 这里 指定文件
            excelWriter = EasyExcel.write(fileName, entity_hw8.class).build();
            WriteSheet writeSheet1 = EasyExcel.writerSheet(num1).build();
            excelWriter.write(list1, writeSheet1);
            WriteSheet writeSheet2 = EasyExcel.writerSheet(num2).build();
            excelWriter.write(list2, writeSheet2);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    public static void write(List<entity_hw8> list, int num) {
        String fileName = "src/main/java/testing/excel/" + "hw8_result.xlsx";
        ExcelWriter excelWriter = null;
        try {
            // 这里 指定文件
            excelWriter = EasyExcel.write(fileName, entity_hw8.class).build();
            WriteSheet writeSheet1 = EasyExcel.writerSheet(num,"Sheet"+ num).build();
            excelWriter.write(list, writeSheet1);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }
}
