package com.oops;
class PersonExample{

    static String name = "kris";
    static int age=12;

    // class name is a constructor even if we don't call a method we can call constructor
    // and can do this operation
    public PersonExample(){
        this.age = 23;
        this.name="biswajit";
        System.out.println("age "+age+"\nname "+name);
        System.out.println("parent default constructor");

    }

    public PersonExample(int i, int i1) {
        this();
        this.age=i;
        this.age=i1;
        System.out.println("age "+age+"\nage "+age);
        System.out.println("parent param constructor");
    }

    public void display(){
        this.age=23;
        System.out.println("age "+age+"\nname "+name);
        System.out.println("parent method");
    }
}

class Employee extends PersonExample{
    public Employee(){
        super(10,12);

        this.age=24;
        super.age=21;
        System.out.println("age :"+age);
        System.out.println("child constructor");
        System.out.println("age using super :"+super.age);
        super.display();

    }
    public void calculate(int num1,int num2){
        this.display();
        super.display();
        this.age=age;
        int sum = num1+num2;
        System.out.println("addition of number "+sum);
    }
}
class Address extends PersonExample{

    int buildingNo=5;
   void addressSearch(){
       this.display();
       this.name="biswajit";
       this.buildingNo=34;
       System.out.println("name of block :"+name+"building no :"+buildingNo);
   }
}

public class ThisAndSuperExample {
    public static void main(String[] args) {
        PersonExample ob1 = new PersonExample();
        ob1.display();
        Employee ob2 = new Employee();
        ob2.calculate(10,12);
        Address ob3 = new Address();
        ob3.addressSearch();
    }
}
