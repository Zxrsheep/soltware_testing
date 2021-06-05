package testing.Entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class entity_hw8 {
    public int getYear() {
        return year;
    }


    public int getMonth() {
        return month;
    }

    public int getDay(){return day;}

    public void setResult(int result) {
        this.result = result;
    }
    /**
     * 用名字去匹配，这里需要注意，如果名字重复，会导致只有一个字段读取到数据
     * result  存储在第四列
     */
    @ExcelProperty(value = "year", index = 0)
    private int year;
    @ExcelProperty(value = "month", index = 1)
    private int month;
    @ExcelProperty(value = "day", index = 2)
    private int day;
    @ExcelProperty(value = "expect", index = 3)
    private int expect;
    @ExcelProperty(value = "result", index = 4)
    private int result;

}
