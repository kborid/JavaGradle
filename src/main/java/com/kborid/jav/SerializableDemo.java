package com.kborid.jav;

import com.kborid.jav.entity.Cat;
import com.kborid.jav.interf.ISay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SerializableDemo {

    private final static String FILE_PATH = "./src/log.txt";

    public static void main(String[] args) {
        try {
            serializeAnimal();
//            deserializeAnimal();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        JPushImpl.getDefault().sendMessage();

        ISay duck = new ISay() {
            @Override
            public void say(String word) {
                System.out.println(name("冲鸭！") + word);
            }
        };
        duck.say("我是一只鸭儿~~");


//        long num = 200L;
//        LongConsumer consumer = System.out::println;
//        LongConsumer consumer1 = l -> System.out.println(l + num);
//        consumer.andThen(consumer1).accept(100L);

        Predicate<Cat> predicate = Objects::isNull;
        Cat dog = null;
        System.out.println(predicate.test(dog));


        Optional<Cat> dog1 = Optional.empty();
        dog1.ifPresent(dog2 -> {
        });

        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc2");
        stringList.add("bbb2");
        stringList.add("ddd1");
        stringList.add("ccc3");
        stringList.add("ccc1");
        stringList.stream()
                .sorted()
                .filter(item -> item.startsWith("a"))
                .forEach(duck::say);


        // 交集
        List<String> listA_01 = new ArrayList<String>() {{
            add("A");
            add("B");
        }};
        List<String> listB_01 = new ArrayList<String>() {{
            add("B");
            add("C");
        }};
        listA_01.retainAll(listB_01);
        System.out.println(listA_01); // 结果:[B]
        System.out.println(listB_01); // 结果:[B, C]

// 差集
        List<String> listA_02 = new ArrayList<String>() {{
            add("A");
            add("B");
        }};
        List<String> listB_02 = new ArrayList<String>() {{
            add("B");
            add("C");
        }};
        listA_02.removeAll(listB_02);
        System.out.println(listA_02); // 结果:[A]
        System.out.println(listB_02); // 结果:[B, C]

// 并集
        List<String> listA_03 = new ArrayList<String>() {{
            add("A");
            add("B");
        }};
        List<String> listB_03 = new ArrayList<String>() {{
            add("B");
            add("C");
        }};
        listA_03.removeAll(listB_03);
        listA_03.addAll(listB_03);
        System.out.println(listA_03); // 结果:[A, B, C]
        System.out.println(listB_03); // 结果:[B, C]
    }

    private static String[] buildStringArr() {
        String[] tmp = new String[30];
        for (int i = 0; i < 30; i++) {
            tmp[i] = String.valueOf(i);
        }
        return tmp;
    }

    private static void serializeAnimal() throws Exception {
        Cat black = new Cat("二哈", 3, buildStringArr());
        System.out.println("序列化前：" + black.toString());
        System.out.println("=================开始序列化================");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        oos.writeObject(black);
        oos.flush();
        oos.close();
    }

    private static void deserializeAnimal() throws Exception {
        System.out.println("=================开始反序列化================");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
        Cat black = (Cat) ois.readObject();
        ois.close();
        System.out.println(black);
    }
}
