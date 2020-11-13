package net.kborid;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;

public class HelloJava {
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999964
        System.out.println(a == b);// false

        BigDecimal ba = new BigDecimal("0.1");
        BigDecimal bb = new BigDecimal("0.1");
        System.out.println(ba.equals(bb));

        reflectTest();
    }

    private static void reflectTest() {
        try {
            Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("net.kborid.vo.UserInfo");
            Object classObject = clazz.newInstance();
            System.out.println("ClassName:" + clazz);

            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(classObject, "我是税");

            Method[] method = clazz.getDeclaredMethods();
            Arrays.stream(method).forEach(System.out::println);

            Method m1 = clazz.getDeclaredMethod("printName");

            m1.setAccessible(true);
            m1.invoke(classObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
