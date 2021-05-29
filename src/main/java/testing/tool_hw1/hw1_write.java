package testing.tool_hw1;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import testing.Entity.entity_hw1;

import java.util.List;

public class hw1_write {

    public static void write(List<entity_hw1> list1, List<entity_hw1> list2 , int num1, int num2) {
        String fileName = "src/main/java/testing/excel/" + "hw1_result.xlsx";
        ExcelWriter excelWriter = null;
        try {
            // 这里 指定文件
            excelWriter = EasyExcel.write(fileName, entity_hw1.class).build();
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
}
