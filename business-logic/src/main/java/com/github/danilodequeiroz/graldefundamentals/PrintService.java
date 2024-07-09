package com.github.danilodequeiroz.graldefundamentals;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintService {

    private static final Logger logger = LoggerFactory.getLogger(PrintService.class);
    private int internalValue;

    public void setInternalValue(int value) {
        this.internalValue = value;
    }

    public int getInternalValue() {
        return internalValue;
    }

    public void print(MessageModel model) {
        logger.info("Printing " + model.getMessage());
        String message = StringUtils.trim(model.getMessage());
        setInternalValue(1);
        System.out.println(StringUtils.trim(message));
    }
}