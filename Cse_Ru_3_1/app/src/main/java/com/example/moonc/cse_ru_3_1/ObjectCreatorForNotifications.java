package com.example.moonc.cse_ru_3_1;

/**
 * Created by moonc on 10/30/2017.
 */

public class ObjectCreatorForNotifications {
    String title;
    String Message;

    public ObjectCreatorForNotifications() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public ObjectCreatorForNotifications(String title, String message) {
        this.title = title;
        Message = message;
    }
}
