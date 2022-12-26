package com.mingming.service;

import com.mingming.controller.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class random {
    @Test
    public void test1() {
        RandomTest.test();
    }

    @Test
    public void test2(){
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new Result(666, a, "傻鸟"));
    }
}
