package com.example.oopspractcice.ObjectAndClassUsage;

 class ObjectClassExample {
    static int a =9 ;
    static int b =9;
    int c =10 ;
    int d = 12;

    public ObjectClassExample(){
        System.out.println("i'm a constuctor");
    }

    {
        System.out.println("non static block 1");
    }
    {
        System.out.println("non static block 2");
    }
   static  {
       System.out.println("static block 2");
    }
  static   {
      System.out.println("static block 3");
    }
   static {
       System.out.println("static block 1");

    }

    void sum(){
        System.out.println("non staic method");
    }

    public static void main(String[] args) {
        ObjectClassExample obj1 = new ObjectClassExample();
        obj1.sum();
    }
}
