package com.kborid.jav.泛型;

import java.util.ArrayList;
import java.util.List;

public class BoundDemo {

    public <T> List<? super T> getAnimal(T obj) {
        List<? super T> list = new ArrayList<>();
        list.add(obj);
        return list;
    }

    public static void main(String[] args) {
        // 1、编译期通过泛型区分不同类型
        // 2、运行期泛型会被擦除
        List<String> strings = new ArrayList<String>();
        List<Integer> integers = new ArrayList<Integer>();
        Class<?> classStringArrayList = strings.getClass();
        Class<?> classIntegerArrayList = integers.getClass();
        if (classStringArrayList.equals(classIntegerArrayList)) {
            System.out.println("泛型测试：类型相同");
        }

        /*
          PECS（Producer Extends Consumer Super）原则。

          Producer Extends 生产者使用Extends来确定上界，往里面放东西来生产
          Consumer Super 消费者使用Super来确定下界，往外取东西来消费

          1、频繁往外读取内容的，适合用上界Extends，即extends 可用于的返回类型限定，不能用于参数类型限定。
          2、经常往里插入的，适合用下界Super，super 可用于参数类型限定，不能用于返回类型限定。
          3、带有 super 超类型限定的通配符可以向泛型对象用写入，带有 extends 子类型限定的通配符可以向泛型对象读取。

          比较官方的说法是逆变与协变描述的是类型转换后的继承关系。
            定义A,B两个类型，A是由B派生出来的子类（A<=B），f()表示类型转换如new List();

            协变： 当A<=B时，f(A)<=f(B)成立
            逆变： 当A<=B时，f(A)>=f(B)成立
            不变： 当A<=B时，上面两个式子都不成立
         */
        // Animal > Person > Child

        Person p = new Child();

//        ArrayList<Person> list = new ArrayList<Child>();

        ArrayList<? extends Person> list1 = new ArrayList<Child>();
//        list1.add(new Child());
//        list1.add(new Person());
//        list1.add(new Animal());
        Person person = list1.get(0);

        List<? super Person> list2 = new ArrayList<Animal>();
        list2.add(new Child());
        list2.add(new Person());
//        list2.add(new Animal());
//        Animal animal1 = list2.get(0);
    }
}

