package com.example.acessmodifierexample.privateexample;
/**
 *  Can you run NewPrivateExample.main()?
 *  Technically, you can’t run it directly because it’s private, and it’s inside a private class.
 *  Java requires the main method to be in a public class to be run directly by the JVM.
 *  So this won’t work unless you:
 *  Move NewPrivateExample to a public top-level class.
 *  Or, make the outer class and inner class public.
 *  Why it matters:private is used for encapsulation — hiding implementation details.
 *  This makes sure that internal logic is not exposed to other parts of the code.
 * */

class PrivateExample{

    // to better understand this code
    private class NewPrivateExample{

        static void hello(){
            System.out.println("new private example");

            // recursion  happening here which causing if i make default ot public it will run
            // else this PrivateExample is not even visible to main class
            //Exception in thread "main" java.lang.StackOverflowError error
            // hello();
            PrivateExample.hello();
        }
    }
    private static void hello(){
        System.out.println("private method example");
    }

    private static void hello(int a ){
        hello();
    }
}

class PrivateClassExample {
    public static void main(String[] args) {

        // we can't access this method here because it has  private access in
        // 'com.example.acessmodifierexample.publicexample.PrivateExample'
//        PrivateExample.hello();
//        PrivateExample.hello(4);
//        PrivateExample.NewPrivateExample.hello();

    }
}
