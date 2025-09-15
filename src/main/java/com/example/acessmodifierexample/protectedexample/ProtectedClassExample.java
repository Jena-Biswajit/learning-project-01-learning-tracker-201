package com.example.acessmodifierexample.protectedexample;

class SuperProtectedTestClass{
    protected static class InnerProtectdTestClass{

        void printInnerClass(){
            System.out.println("protected inner class");
        }
    }

}

// ToDo (for better understanding)
// to extends this inner class must be static else we need to create
// object which is not a proper solution
// we can inherit protected class
class SubProtected2 extends SuperProtectedTestClass.InnerProtectdTestClass{

    void subProtected(){
        System.out.println("innter class inheritance ");

        /*
        * In Java, method calls must be placed inside:
        * a method (e.g., main)
        * a static or instance initializer block
        * a constructor
        * */

        printInnerClass();
    }

}

public class ProtectedClassExample {
    public static void main(String[] args) {

        // since SubProtected2 is instance class you need to create object to call the inner method
        SubProtected2 ob1 = new SubProtected2();
        ob1.subProtected();
    }
}
