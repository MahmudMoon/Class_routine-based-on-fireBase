package com.example.moonc.cse_ru_3_1;

/**
 * Created by moonc on 10/11/2017.
 */

public class ObjectCreator {


    private String time;
    private String class_name;

    public ObjectCreator() {


    }



    public ObjectCreator(String time , String class_name) {
        this.time = time;
        this.class_name = class_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }


}
