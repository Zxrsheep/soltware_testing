package testing.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hw3Controller {
    @RequestMapping("/hw3")
    public String hw3(@RequestParam("id") int id){
        return "hw3";
    }


}
