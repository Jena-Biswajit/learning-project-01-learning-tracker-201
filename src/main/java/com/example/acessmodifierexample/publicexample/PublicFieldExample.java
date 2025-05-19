package com.example.acessmodifierexample.publicexample;


class AdditionOftwoNumber{
    public int num1 ;
    public float num2 ;
//    addition of two number using public keyword
//    access this keyword in other package

    float sum(int num1 , float num2){
        float result = num1+num2;
        return result;
    }
}

class AdditionofNewNumber extends AdditionOftwoNumber{

    float sum (int num1 , float num2 , int num3 ){
        float result = num1 + num2 + num3;
        return result ;
    }

}

public class PublicFieldExample {
    public static void main(String[] args) {
        AdditionOftwoNumber ob1 = new AdditionOftwoNumber();
        ob1.num1 = 9 ;
        ob1.num2 = 10 ;
        float result = ob1.sum(ob1.num1,ob1.num2);
        System.out.println(result);
        AdditionofNewNumber ob2 = new AdditionofNewNumber();
        float newResult = ob2.sum(5,5,8);
        System.out.println(newResult);
    }
}
