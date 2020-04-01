package com.crazzy.junit.service.impl;

import com.crazzy.junit.service.SomeDataService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatorServiceImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        int sum = 0;

        for(int value: data) {
            sum += value;
        }

        return sum;
    }

    public int calculateSumWithoutArg() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for(int value: data) {
            sum += value;
        }

        return sum;
    }
}
