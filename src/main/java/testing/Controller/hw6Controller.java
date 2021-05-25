package testing.Controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import testing.Entity.entity_hw6;
import testing.hw.hw6;
import testing.tool_hw6.hw6_read;
import testing.tool_hw6.hw6_write;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class hw6Controller {

    @ApiOperation(value = "hw6_test",notes = "输入本月分钟数以及本年至本月未按时缴费次数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "minutes", value = "本月分钟数",required = true,dataType = "int"),
            @ApiImplicitParam(name = "times", value = "本年至本月未按时缴费次数",required = true,dataType = "int")
    })
    @GetMapping("/telecomCharge")
    public String hw6(@RequestParam("minutes") int minute,@RequestParam("times") int times){
        boolean bool_boundary = hw6.boundary(minute,times);
        if(!bool_boundary)
            return "输入超出理论边界！";
        double charge = hw6.calculation(minute,times);
        return Double.toString(charge);
    }

    @ApiOperation(value = "hw6",notes = "输入本月分钟数以及本年至本月未按时缴费次数")
    @ApiImplicitParam(name = "num" , value = "对应sheet序号",required = true,dataType = "int")
    @PostMapping("/hw6")
    public List<entity_hw6> hw6(@RequestParam(value = "file",required = true) MultipartFile file
            , @RequestParam("num") int num)
            throws IOException {
        System.out.println("111");
        hw6 hw = new hw6();
        List<entity_hw6> list = hw6_read.repeatedRead(file,num);
        List<entity_hw6> list1 = hw6.ReadAndWrite(file,num);
        return list1;
    }

}
