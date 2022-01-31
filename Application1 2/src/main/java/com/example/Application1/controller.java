package com.example.Application1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.Optional;
import javax.naming.ServiceUnavailableException;

import com.example.Application1.Model.CommonData;
import com.example.Application1.Service.service;
//Send Data to application17
@RestController
public class controller {
    @Autowired
    private service myservice;

    @PostMapping("/sendData")
    public CommonData home(){
       CommonData res=new CommonData();
        //System.out.println(liveUserConfig.getUsername());
        try {
            res=myservice.sendMyCommonData(new CommonData(1,"app1"));
            System.out.print(res);
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }


}
