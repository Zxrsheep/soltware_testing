package testing.Controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import testing.Entity.entity_hw8;
import testing.hw.hw8;

import java.io.IOException;
import java.util.List;

@RestController
public class hw8Controller {

    @ApiOperation(value = "hw8_test",notes = "输入年月日")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "years", value = "年",required = true,dataType = "int"),
            @ApiImplicitParam(name = "months", value = "月",required = true,dataType = "int"),
            @ApiImplicitParam(name = "days", value = "日",required = true,dataType = "int")
    })
    @GetMapping("/returnWeek")
    public String hw8(@RequestParam("years") int years, @RequestParam("months") int months, @RequestParam("days") int days){
        boolean bool_boundary = hw8.boundary(years,months,days);
        if(!bool_boundary) {
            return "输入超出理论边界！";
        }
        int result = hw8.temp(years,months,days);
        return Integer.toString(result);
    }

    @ApiOperation(value = "hw8",notes = "输入年月日")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num" , value = "对应sheet序号",required = true,dataType = "int")
    })
    @PostMapping("/hw8")
    public List<entity_hw8> hw8(@RequestParam("num") int num)
            throws IOException {
        System.out.println("111");
        hw8 hw = new hw8();
        List<entity_hw8> list1 = hw8.ReadAndWrite(num);
        //list1.addAll(list);
        return list1;
    }
}
