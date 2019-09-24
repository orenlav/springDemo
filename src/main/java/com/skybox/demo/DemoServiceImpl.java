package com.skybox.demo;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    public String get(){
        return getClass().getSimpleName();
    }

}

