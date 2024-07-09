package com.github.danilodequeiroz.gradlefundamentals;

import com.github.danilodequeiroz.graldefundamentals.MessageModel;
import com.github.danilodequeiroz.graldefundamentals.PrintService;
import org.junit.jupiter.api.Test;

public class PrintServiceTest {

    @Test
    void testService() {
        PrintService printService = new PrintService();
        MessageModel model = new MessageModel("mocked message");
        printService.print(model);
        int expectedValue = 1;
        assert (printService.getInternalValue() == expectedValue);
    }
}