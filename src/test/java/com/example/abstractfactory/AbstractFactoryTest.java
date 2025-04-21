package com.example.abstractfactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractFactoryTest{
    @Test
    void testWindowsFactoryButton() {
        GUIFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        assertNotNull(button);
    }

    @Test
    void testMacOSFactoryButton() {
        GUIFactory factory = new MacOSFactory();
        Button button = factory.createButton();
        assertNotNull(button);
    }
}