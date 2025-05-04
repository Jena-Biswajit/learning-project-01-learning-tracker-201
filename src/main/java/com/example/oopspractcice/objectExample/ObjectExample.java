package com.example.oopspractcice.objectExample;

// use of iobjects and classes in java
public class ObjectExample {

   static int a = 9 ;
   private int b =10;

   // Unexpected token
   //a = 10 ;
    {
        a =10 ; // no error
    }
    class Abc{
       // a = 10;  // Unexpected token
    }

    public static void main(String[] args) {

        ObjectExample ob1 = new ObjectExample();
        ob1.a = 15;
        ob1.b = 16;
        // so here we can't do this way we need to access the data through object


        int c = ob1.a + ob1.b  ;

        System.out.println(c);
    }

}
