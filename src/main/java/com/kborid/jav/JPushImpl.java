package com.kborid.jav;

import com.kborid.jav.interf.JPushInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class JPushImpl implements JPushInterface {

    private static JPushImpl pushImpl = new JPushImpl();
    private JPushImpl(){}

    public static JPushImpl getDefault() {
        return pushImpl;
    }

    @Override
    public String getMessage() {
        return "我是推送消息~~~";
    }

    @Override
    public String getTAG() {
        return "J-PUSH";
    }

    private static Map<String, StringBuilder> dsrMap = new HashMap<String, StringBuilder>() {
        {
            put("2", new StringBuilder("222222、"));
            put("3", new StringBuilder("333333、"));
        }
    };

    private static String NAME = "duan";
    private static String TAG = "、";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(String.valueOf(i));
        }

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String ssdw) {
                dsrMap.merge(ssdw, new StringBuilder(NAME).append(TAG), StringBuilder::append);
//                if (dsrMap.get(ssdw) != null) {
//                    dsrMap.get(ssdw).append(NAME).append(TAG);
//                } else {
//                    dsrMap.put(ssdw, new StringBuilder(NAME).append(TAG));
//                }
            }
        });

        dsrMap.forEach((s, stringBuilder) -> System.out.println(s + ":" + stringBuilder.toString()));
    }
}

