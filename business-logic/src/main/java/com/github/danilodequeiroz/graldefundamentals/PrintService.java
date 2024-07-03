package com.github.danilodequeiroz.graldefundamentals;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintService {

    private static Logger logger = LoggerFactory.getLogger(PrintService.class);

    public void print(MessageModel model) {
        logger.info("Printing " + model.getMessage());
        String message = model.getMessage();
        System.out.println(StringUtils.trim(message));
    }
}