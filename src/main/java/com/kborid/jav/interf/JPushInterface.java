package com.kborid.jav.interf;

public interface JPushInterface {

    String getMessage();

    String getTAG();

    default void sendMessage() {
        System.out.println(getTAG() + ":" + getMessage());
    }

    static void aa() {
        System.out.println("aa");
    }

    static void bb() {
        System.out.println("bb");
    }
}
