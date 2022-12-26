package com.mingming.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTest {
    public static void test() {
        Random random = new Random();
        int j = 0;
        List<Integer> list1 = new ArrayList<Integer>();
        int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0;
        while (true){
            while (j < 10000) {
                int i = random.nextInt(1000);
                if (i <= 825) {
                    num6++;
                } else if (i <= 925) {
                    num5++;
                } else if (i <= 975) {
                    num4++;
                } else if (i <= 988) {
                    num3++;
                } else if (i <= 995) {
                    num2++;
                } else {
                    num1++;
                    list1.add(j);
                }
                j++;
            }
            if(num1 > 25){
                j = 0;
                num1 = 0;
                num2 = 0;
                num3 = 0;
                num4 = 0;
                num5 = 0;
                num6 = 0;
                list1.clear();
            }else break;
        }

        int k = 1;
        System.out.println("共 10000 次抽奖");
        System.out.print("你一共抽到100%返还 " + num1 + " 次, 其中分别在第");
        for (Integer integer : list1) {
            if (k % 18 == 0) {
                System.out.println();
            }
            k++;
            System.out.print(integer + ", ");
        }
        System.out.println("次抽到");
        System.out.println("抽到88.8%返还 " + num2 + " 次");
        System.out.println("抽到66.6%返还 " + num3 + " 次");
        System.out.println("抽到28.8%返还 " + num4 + " 次");
        System.out.println("抽到18.8%返还 " + num5 + " 次");
        System.out.println("抽到8.88%返还 " + num6 + " 次");
    }
}
