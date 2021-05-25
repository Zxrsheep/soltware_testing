package testing.Entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class entity_hw6 {
    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    /**
     * 用名字去匹配，这里需要注意，如果名字重复，会导致只有一个字段读取到数据
     * result  存储在第四列
     */
    @ExcelProperty(value = "minutes", index = 0)
    private int minutes;
    @ExcelProperty(value = "times", index = 1)
    private int times;
    @ExcelProperty(value = "expect", index = 3)
    private double expect;
    @ExcelProperty(value = "result", index = 4)
    private double result = -1;

}
