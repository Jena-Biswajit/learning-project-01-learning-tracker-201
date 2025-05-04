package com.example.task;



 class App1 {


   static  {
        System.out.println("static block 1");

    }
    static {
        System.out.println("static block 2");

    }
    static {
        System.out.println("static block 3");

    }

    {
        System.out.println(" non static block 1");
    }  {
        System.out.println(" non static block 2");
    }  {
        System.out.println(" non static block 3");
    }






    public static void main(String[] args) {

        App1 ob = new App1();

    }
}
