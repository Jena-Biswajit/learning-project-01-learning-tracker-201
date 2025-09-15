package com.example.nonstatickeyword;

class NonStaticKeyword{

    int employeeId = 120 ;
    int salary = 150 ;

    public NonStaticKeyword(){
        this.employeeId = employeeId;
        this.salary = salary;

        System.out.println(this.employeeId);
        System.out.println(this.salary);

    }
    void employeeDeails(){
        System.out.println(employeeId);
        System.out.println(salary);
    }

}
class NewEmpolyee extends NonStaticKeyword{

    void employeeDeails(){

        int employeeId = 24;
        int salary = 10000 ;

        System.out.println(employeeId);
        System.out.println(salary);
    }
}

public class NonStaticKeywordExample {
    public static void main(String[] args) {

        NonStaticKeyword ob1 = new NonStaticKeyword();
        ob1.employeeDeails();

        NewEmpolyee obj1 = new NewEmpolyee();
        obj1.employeeDeails();
    }
}
