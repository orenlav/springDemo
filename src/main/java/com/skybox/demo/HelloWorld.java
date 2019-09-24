package com.skybox.demo;

import com.skybox.demo.calc.CalcService;
import com.skybox.demo.calc.CalcServiceFactory;
import com.skybox.demo.calc.CalcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Autowired
    private DemoService service;
    @Autowired
    private CalcServiceFactory calcServiceFactory;
    @Autowired
    private PrototypeService proto;
    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/")
    public String index(){
        return service.get();
    }

    // -------------- factory

    @RequestMapping("/factory")
    public String factory(@RequestParam String type){
        CalcType calcType = CalcType.valueOf(type);
        CalcService calcService = calcServiceFactory.get(calcType);
        return calcService.get();
    }


    // -------------- prototype

    @RequestMapping("/proto1")
    public String protoInvalid(){
        return ""+ proto.inc();
    }

    @RequestMapping("/proto2")
    public String protoCorrect(){
        PrototypeService bean = applicationContext.getBean(PrototypeService.class);
        return ""+ bean.inc();
    }

    // -------------- lazy

//    @Autowired
//    LazyService lazyService;

    @RequestMapping("/lazy")
    public String lazy(){
        applicationContext.getBean(LazyService.class);
        return "";
    }

}



