package com.example.classdeclarationtesting;

// to understand
class PrivateKeyword {
    // this will not run
    static void main(String[] args) {
        System.out.println("default main method");
    }

// this will run
//    public static void main(String[] args) {
//
//    }

    // this will run
    static class Testing {
        public static void main(String[] args) {
            System.out.println("static class method");
        }
    }

  // this will run but will not go inside main method
    public class Testing1 {
        public static void main(String[] args) {
            System.out.println("public inner class");
        }
    }

    // it will going to bydefault main class
    protected class Testing2{
        public static void main(String[] args) {
            System.out.println("protected inner class");
        }
    }

    private class Testing3{
        public static void main(String[] args) {
            System.out.println("private inner class");
        }
    }

}

class NewTesting extends PrivateKeyword{

    // here main method will not call
//    Testing1.main();
}

public class ClassExample3 {
    public static void main(String[] args) {
        System.out.println(" main method");
    }
}
