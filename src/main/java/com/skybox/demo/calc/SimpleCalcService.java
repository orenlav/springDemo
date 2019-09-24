package com.skybox.demo.calc;

import org.springframework.stereotype.Service;

@Service
public class SimpleCalcService implements CalcService{
    @Override
    public String get() {
        return getClass().getSimpleName();
    }

    @Override
    public CalcType getType() {
        return CalcType.SIMPLE;
    }
}

