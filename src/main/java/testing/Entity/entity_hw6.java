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

    public void setResult(double result){this.result = result;}

    /**
     * 用名字去匹配value，这里需要注意，如果名字重复，会导致只有一个字段读取到数据
     * expect 为预期结果，只存储并写入新的的excel
     * result hw中计算后赋值
     * index 对应的是sheet表的列数
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
