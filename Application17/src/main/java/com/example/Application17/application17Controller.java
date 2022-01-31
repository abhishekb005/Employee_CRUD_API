package com.example.Application17;

import com.example.Application17.Model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class application17Controller {
    @PostMapping("/recieveData")
    public CommonData home(@RequestBody CommonData req){
        //System.out.println(liveUserConfig.getUsername());
        System.out.println(req.toString());
        return new CommonData(2, "data");
    }
    
    @GetMapping("/")
    public String home1(){
        
    return "Hello ";
    }
}
