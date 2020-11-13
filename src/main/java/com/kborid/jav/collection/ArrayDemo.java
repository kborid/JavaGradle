package com.kborid.jav.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayDemo
 *
 * @description:
 * @author: duanwei
 * @email: duanwei@thunisoft.com
 * @version: 1.0.0
 * @date: 2020/8/7
 */
public class ArrayDemo {
    public static void main(String[] args) {
        System.out.println("ensureCapacity方法测试");
        ensureCapacityTest();
        System.out.println("copy测试");
        copy();
        System.out.println("asList测试");
        asListDemo();
    }

    private static void asListDemo() {
        List<String> list = Arrays.asList("我", "是", "shui");
        System.out.println("size:" + list.size());
        int[] test = {1, 2, 3, 4};
        List list1 = Arrays.asList(test, test);
        System.out.println("size1:" + list1.size());
    }

    private static void ensureCapacityTest() {
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前：" + (endTime - startTime));


        ArrayList<Object> list1 = new ArrayList<Object>();
        final int N1 = 10000000;
        list1.ensureCapacity(N1);
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < N1; i++) {
            list1.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法后：" + (endTime1 - startTime1));
    }

    private static void copy() {
        int[] elementData = new int[]{2, 3, 4, 5, 6, 0, 0, 0, 0, 0};
        int size = 5;
        int index = 3;
        int element = 88;
        size++;
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        Arrays.stream(elementData).forEach(System.out::println);
    }
}
