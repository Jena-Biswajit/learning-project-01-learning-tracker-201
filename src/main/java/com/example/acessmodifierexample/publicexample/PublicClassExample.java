package com.example.acessmodifierexample.publicexample;

class Hello{
    // now i can make it public
    public static class NewHello{
        public static int hello(){
            System.out.println("nested public class");
            return 0 ;
        }
        // we can overload the method with no problem
        public static void hello(int a){
            System.out.println("overloaded method ");
        }
    }

    // here it is not overloading jvm is thinking it is a method of Hello class
    // it has no relationship with innerclass method
    public static void hello(int a ){
        System.out.println("method of super class");
    }
}

class ChildHello extends Hello.NewHello{
    public static void main(String[] args) {
        System.out.println("extending innner class");

        ChildHello.hello(9);
        ChildHello.hello();
    }
}


public class PublicClassExample {
    public static void main(String[] args) {
        System.out.println("hello world");

        //this is how nested class is called
        Hello.NewHello.hello();
        Hello.NewHello.hello(6);
        Hello.NewHello.hello(7);
        Hello.hello(8);
    }
}
