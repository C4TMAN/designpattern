package com.c4tman.play.design.pattern.frs;

import com.c4tman.play.design.pattern.frs.service.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangxiaoman on 2018/6/28.
 */
@RestController
public class IndexController {
    @Autowired
    ServiceA serviceA;

    @RequestMapping("/a")
    public String indexA(){
        serviceA.method1();
        return "AAA";
    }

    @RequestMapping("/b")
    public String indexB(){
        serviceA.method1(1);
        return "BBB";
    }

    @RequestMapping("/c")
    public String indexC(){
        serviceA.method2(null, "123");
        return "CCC";
    }
}
