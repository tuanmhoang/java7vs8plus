package com.tuanmhoang.java7vs8plus.service;

import java.util.List;
import java.util.concurrent.Callable;

public class SumThread implements Callable<Integer> {

    private List<Integer> inputs;

    public SumThread(List<Integer> inputs) {
        this.inputs = inputs;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < inputs.size(); i++) {
            sum += inputs.get(i);
        }
        return sum;
    }
}
