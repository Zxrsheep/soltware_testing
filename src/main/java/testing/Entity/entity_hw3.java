package testing.Entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class entity_hw3 {
    public int getDisplays() {
        return displays;
    }


    public int getHosts() {
        return hosts;
    }

    public int getPeripherals(){return peripherals;}

    public void setResult(double result) {
        this.result = result;
    }
    /**
     * 用名字去匹配，这里需要注意，如果名字重复，会导致只有一个字段读取到数据
     * result  存储在第四列
     */
    @ExcelProperty(value = "displays", index = 0)
    private int displays;
    @ExcelProperty(value = "hosts", index = 1)
    private int hosts;
    @ExcelProperty(value = "peripherals", index = 2)
    private int peripherals;
    @ExcelProperty(value = "expect", index = 3)
    private double expect;
    @ExcelProperty(value = "result", index = 4)
    private double result = -1;

}
