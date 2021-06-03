package testing.Entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class entity_hw1 {
    public int geta() {
        return a;
    }


    public int getb() {
        return b;
    }

    public int getc(){return c;}

    public void setResult(String result) {
        this.result = result;
    }
    /**
     * 用名字去匹配，这里需要注意，如果名字重复，会导致只有一个字段读取到数据
     * result  存储在第四列
     */
    @ExcelProperty(value = "a", index = 0)
    private int a;
    @ExcelProperty(value = "b", index = 1)
    private int b;
    @ExcelProperty(value = "c", index = 2)
    private int c;
    @ExcelProperty(value = "result", index = 3)
    private String result;

}
