package testing.Controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import testing.Entity.entity_hw1;
import testing.hw.hw1;

import java.io.IOException;
import java.util.List;

@RestController
public class hw1Controller {

    @ApiOperation(value = "hw1_test",notes = "输入abc三条边")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", value = "第一条边",required = true,dataType = "int"),
            @ApiImplicitParam(name = "b", value = "第二条边",required = true,dataType = "int"),
            @ApiImplicitParam(name = "c", value = "第三条边",required = true,dataType = "int")
    })
    @GetMapping("/returnType")
    public String hw1(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c){
        boolean bool_boundary = hw1.boundary(a,b,c);
        if(!bool_boundary) {
            return "输入超出理论边界！";
        }
        String result = hw1.result(hw1.type(a,b,c));
        return result;
    }

    @ApiOperation(value = "hw1",notes = "输入abc三条边")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num" , value = "对应sheet序号",required = true,dataType = "int")
    })
    @PostMapping("/hw1")
    public List<entity_hw1> hw1(@RequestParam("num") int num)
            throws IOException {
        System.out.println("111");
        hw1 hw = new hw1();
        List<entity_hw1> list1 = hw1.ReadAndWrite(num);
        //list1.addAll(list);
        return list1;
    }
}
