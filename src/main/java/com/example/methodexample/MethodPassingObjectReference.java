package com.example.methodexample;

class Dog {
    String name ;
    public Dog(String name){
        this.name = name ;
    }
    public String getName(){
        return name ;
    }
    public void setName(String name){
        this.name = name;
    }
}
public class MethodPassingObjectReference {

    public static void setNewName(Dog myDog , String newName){
        // now if i set local reference dog to point to a new dog objects
        myDog = new Dog("rohit");

        // in this point myDog is point to original object reference
        myDog.setName(newName);
    }
    public static void main(String[] args) {
        Dog myDog = new Dog("samir");
        System.out.println("the original name is :"+ myDog.getName());

        setNewName(myDog , "jitendra");
        System.out.println("the new name is :"+ myDog.getName());
    }
}
