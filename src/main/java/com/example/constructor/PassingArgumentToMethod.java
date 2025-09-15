package com.example.constructor;

public class PassingArgumentToMethod {

    double paymentDues(double roomRent ,double currentBill, double lineBill ){

//        int roomRent ;

        double totalBill = roomRent + currentBill + lineBill ;
        return totalBill;
    }



    public static void main(String[] args) {

        PassingArgumentToMethod ob1 = new PassingArgumentToMethod();

       double totalBill = ob1. paymentDues(12000.00 , 2000.00 , 500.00);
        System.out.println(totalBill);
    }

}
