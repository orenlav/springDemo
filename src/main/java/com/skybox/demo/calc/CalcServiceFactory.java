package com.skybox.demo.calc;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalcServiceFactory implements InitializingBean {
    @Autowired
    private CalcService[] calcServices;

    private Map<CalcType, CalcService> calcMap;

    public CalcServiceFactory(){
//        init(); DONT!
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    private void init() {
        calcMap = Arrays.stream(calcServices).collect(Collectors.toMap(CalcService::getType, v -> v));
    }

    public CalcService get(CalcType calcType)
    {
        return calcMap.get(calcType);
    }

}
