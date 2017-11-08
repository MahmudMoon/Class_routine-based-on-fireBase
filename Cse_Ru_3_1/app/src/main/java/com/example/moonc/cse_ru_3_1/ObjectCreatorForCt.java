package com.example.moonc.cse_ru_3_1;

/**
 * Created by moonc on 10/15/2017.
 */

public class ObjectCreatorForCt {
    String ct_time;
    String ct_xm;


    public ObjectCreatorForCt() {


    }

    public ObjectCreatorForCt(String ct_time, String ct_xm) {
        this.ct_time = ct_time;
        this.ct_xm = ct_xm;
    }

    public String getCt_time() {
        return ct_time;
    }

    public void setCt_time(String ct_time) {
        this.ct_time = ct_time;
    }

    public String getCt_xm() {
        return ct_xm;
    }

    public void setCt_xm(String ct_xm) {
        this.ct_xm = ct_xm;
    }

}
