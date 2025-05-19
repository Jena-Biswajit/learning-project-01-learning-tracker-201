package com.example.classdeclarationtesting;

class NewClass{
    String countryName = "india";

    String namePrint(){
        countryName = "austerlia";
        System.out.println("name of new country is :" + countryName);

        return countryName;
    }
}

// the program demonstrating using instance variable
public class Classexample2 {
    public static void main(String[] args) {
        NewClass ob1 = new NewClass();
        ob1.countryName = "india";
        System.out.println(" country name is :"+ ob1.countryName);

        String newName =ob1.namePrint();
        System.out.println(" country name is :"+ ob1.countryName);
    }
}
