package com.example.interfaceexample;

public interface HelloWorld {

//    Not allowed in interface
//    public HelloWorld(){
//
//    }

    int d =9;
    // interface default declaration for variable is public static final
   //d = 0; // we can't modify here error :Unexpected token
    default void sum(){
         int a = 5 , b= 6 ;
         int c = a+b;
        System.out.println(c);
        a = 0 ;
     }
}

 interface SecondIinterface{
    //
}

class NewHelloWorld implements HelloWorld{


    // 'sum()' in 'com.example.interfaceexample.NewHelloWorld' clashes with 'sum()'
    // in 'com.example.interfaceexample.HelloWorld';
    // attempting to assign weaker access privileges ('package-private'); was 'public'
//    @Override
//    public void sum(){
//
//    }
//
//    void add(){
//
//    }

    // Missing method body, or declare abstract
    // so we can't declare a method inside child class
//    void summ();

    public static void main(String[] args) {


//        HelloWorld ob1 = new HelloWorld() {
//            @Override
//            public void sum() {
//                HelloWorld.super.sum();
//            }
//        };


        HelloWorld ob1 = new NewHelloWorld();

        ob1.sum();




    }

}
