package com.github.danilodequeiroz.graldefundamentals;

import  java.lang.String;

public class MessageModel {

    private String message;

    public MessageModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}