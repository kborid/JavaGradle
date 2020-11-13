package com.kborid.jav.interf;

public interface ISay {
    void say(String word);

    default String name(String name) {
        return name;
    }
}
