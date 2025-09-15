package com.example.acessmodifierexample.protectedexample;

class ProtectedField{
    protected String name = "biswajit";

    // can access the protected field in same package
    String printName(){
        return name;
    }
}
class SubProtectedField extends ProtectedField{
    String subProtectedMethod(){

        String name = "ram";
        ProtectedField ob1 = new ProtectedField();
//        ob1.name = "suresh";
//        return ob1.name;
        return name;
    }
}


public class ProtectedFields {
    protected String name ;
    public static void main(String[] args) {

        ProtectedField ob1 = new ProtectedField();

        // we can access protected field here as well
        // now the

        // TODO understand this instance variable access
//        ob1.name = "rupesh";

        String newName = ob1.printName();
        System.out.println("my name is :"+ newName);

        SubProtectedField ob2 = new SubProtectedField();
        String newName2 =ob2.subProtectedMethod();
        System.out.println("my new name is :"+ newName2);
    }
}
