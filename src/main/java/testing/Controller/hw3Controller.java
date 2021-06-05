package testing.Controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import testing.Entity.entity_hw3;
import testing.hw.hw3;

import java.io.IOException;
import java.util.List;

@RestController
public class hw3Controller {

    @ApiOperation(value = "hw3_test",notes = "输入显示屏，主机，外设三内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "displays", value = "显示屏",required = true,dataType = "int"),
            @ApiImplicitParam(name = "hosts", value = "主机",required = true,dataType = "int"),
            @ApiImplicitParam(name = "peripherals", value = "外设",required = true,dataType = "int")
    })
    @GetMapping("/returnCommission")
    public String hw3(@RequestParam("displays") int displays, @RequestParam("hosts") int hosts, @RequestParam("peripherals") int peripherals){
        boolean bool_boundary = hw3.boundary(displays,hosts,peripherals);
        if(!bool_boundary) {
            return "输入超出理论边界！";
        }
        double result = hw3.commission(displays,hosts,peripherals);
        return Double.toString(result);
    }

    @ApiOperation(value = "hw3",notes = "输入显示屏，主机，外设三内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num" , value = "对应sheet序号",required = true,dataType = "int")
    })
    @PostMapping("/hw3")
    public List<entity_hw3> hw1(@RequestParam("num") int num)
            throws IOException {
        System.out.println("111");
        hw3 hw = new hw3();
        List<entity_hw3> list1 = hw3.ReadAndWrite(num);
        //list1.addAll(list);
        return list1;
    }
}
