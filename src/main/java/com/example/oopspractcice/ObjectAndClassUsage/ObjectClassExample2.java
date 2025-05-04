package com.example.oopspractcice.ObjectAndClassUsage;

 class PrivateExample{

     private int num1 ;
     private int num2 ;

     public void setNum1(int num1 , int num2){
         this.num1 = num1;
         this.num2 = num2;
     }

     public void sum(){
         int addition = num1+num2 ;
         System.out.println("addition of number is "+ addition);
     }
   public void sub(){
         int subtraction = num1-num2 ;
         System.out.println("addition of number is "+ subtraction);
     }

}

//It is a simple example showing a class Numbers containing two variables
//which can be accessed and updated only by instance of the object created.
 public class ObjectClassExample2 {

    public static void main(String[] args) {

        PrivateExample ob1 = new PrivateExample();
       // ob1.num1 = 5 ; // if it is private then it may not even able to watch that in other classes
        //ob1.num2 = 7;

        ob1.setNum1(2,4);

        ob1.sum();
        ob1.sub();

    }
}
