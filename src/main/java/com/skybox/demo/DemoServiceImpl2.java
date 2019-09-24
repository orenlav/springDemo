package com.skybox.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

public class DemoServiceImpl2 implements DemoService {
    public String get(){
        return getClass().getSimpleName();
    }

}
