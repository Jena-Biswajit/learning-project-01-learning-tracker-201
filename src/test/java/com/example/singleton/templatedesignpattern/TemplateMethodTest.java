package com.example.singleton.templatedesignpattern;

import com.example.templatedesignpattern.Beverage;
import org.junit.jupiter.api.Test;
import com.example.templatedesignpattern.Coffee;
import com.example.templatedesignpattern.Tea;

public class TemplateMethodTest {

    @Test
    public void testTeaPreparation() {
        Beverage tea = new Tea();
        tea.prepareBeverage();
        // Output: Boiling water, Steeping the tea, Pouring into cup, Adding lemon
    }

    @Test
    public void testCoffeePreparation() {
        Beverage coffee = new Coffee();
        coffee.prepareBeverage();
        // Output: Boiling water, Dripping coffee, Pouring into cup, Adding sugar and milk
    }
}