package com.kborid.jav.泛型;

/**
 * 泛型类
 */
public class Fruit<T> {

    private T value;

    Fruit(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    /**
     * 泛型方法
     */
    public <P> T findValue(P key) {
        return (T) new Fruit("Apple").getValue();
    }

    /**
     * 静态方法必须在方法上重新生命泛型类型
     */
    public static <T> void show1(T key) {
    }

    // 无法重载相同泛型参数方法
//    public void print(List<String> list) {
//    }

//    public void print(List<Boolean> list) {
//    }
}
