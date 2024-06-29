package com.github.danilodequeiroz.graldefundamentals;

import org.apache.commons.lang3.StringUtils;

public class PrintService {

    public void print(MessageModel model){
        String message = model.getMessage();
        System.out.println(StringUtils.trim(message));
    }
}