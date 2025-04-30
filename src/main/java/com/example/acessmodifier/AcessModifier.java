package com.example.acessmodifier;

 class AcessModifierExample {

    public int publicVar = 1 ;
    private int privateVar = 2 ;
    protected int protectedVar = 3;
    int defaultVar =0 ;

    public void setPublicVar(){
        System.out.println("public method");
    }


    // private means “only visible within the enclosing class”.
    private void setPrivateVar(){
        System.out.println("private method");
    }

    //protected means “only visible within the enclosing class and any subclasses”.
    protected void setProtectedVar(){
        System.out.println("protocted method");
    }

    void setDefaultVar(){
        System.out.println("defalt method");
    }

    public void acessModifier(){
        System.out.println(defaultVar);
        System.out.println(publicVar);
        System.out.println(privateVar);
        System.out.println(protectedVar);

        setDefaultVar();
        setPublicVar();
        setPrivateVar();
        setProtectedVar();

    }

}

class AcessModifierNew{
    public static void main(String[] args) {
        AcessModifierExample ob2 = new AcessModifierExample();

        //it will show error :'setPrivateVar()' has
        //private access in 'com.example.acessmodifier.AcessModifierExample'
//      ob2.setPrivateVar();
        ob2.setProtectedVar();
        ob2.setDefaultVar();
        ob2.setPublicVar();
    }
}

public class AcessModifier{
    public static void main(String[] args) {
        AcessModifierExample ob1 = new AcessModifierExample();
        ob1.acessModifier();
    }
    protected void display() {
        System.out.println("Protected subclass class");
    }
}


