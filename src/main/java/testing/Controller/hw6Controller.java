package testing.Controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import testing.hw.hw6;

@RestController
public class hw6Controller {

    @ApiOperation(value = "hw6",notes = "输入本月分钟数以及本年至本月未按时缴费次数")
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
}
