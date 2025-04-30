package com.example.acessmodifier2;
import com.example.acessmodifier.AcessModifier;

public class AcessModifier2 extends AcessModifier {

    public static void main(String[] args) {
        // error : Cannot resolve symbol 'AcessModifierExample'
        // default modifier can't be access in different package
//        AcessModifierExample ob1 = new AcessModifierExample();

        // no error because it is public modifier
        // so here also i can call the public method
        // any method other than this will show error
        // Cannot resolve method 'acessModifier' in 'AcessModifier'
        AcessModifier ob1 = new AcessModifier();
//        ob1.display(); // here we can't call the display method
        AcessModifier2 ob2 = new AcessModifier2();
        ob2.display(); // but we can call here because we inherit the accessmodifier
    }
}

